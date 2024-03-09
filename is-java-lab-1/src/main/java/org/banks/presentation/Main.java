package org.banks.presentation;

import org.banks.application.servicesimplementations.ClientServiceImpl;
import org.banks.application.servicesimplementations.LoginServiceImpl;
import org.banks.corebusinessrules.accounts.builders.CreditAccountBuilder;
import org.banks.corebusinessrules.accounts.builders.DebitAccountBuilder;
import org.banks.corebusinessrules.accounts.builders.DepositAccountBuilder;
import org.banks.corebusinessrules.accounts.percentage.CreditPercentage;
import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.globalfinancialmessagingservice.GlobalFinancialMessagingService;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.corebusinessrules.services.ports.LoginService;
import org.banks.corebusinessrules.services.repositories.AdminsRepository;
import org.banks.corebusinessrules.services.repositories.BankRepository;
import org.banks.corebusinessrules.services.repositories.ClientRepository;
import org.banks.corebusinessrules.services.timemanager.DefaultTimeManagerImpl;
import org.banks.corebusinessrules.services.timemanager.TimeManager;
import org.banks.datalayer.InMemoryAdminRepositoryImpl;
import org.banks.datalayer.InMemoryBankRepositoryImpl;
import org.banks.datalayer.InMemoryClientRepositoryImpl;
import org.banks.presentation.controllers.*;
import org.banks.presentation.controllers.useractioncontrollers.*;
import org.banks.presentation.routing.DumbRouter;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        DumbRouter router = new DumbRouter();

        BankRepository bankRepository = new InMemoryBankRepositoryImpl();
        ClientRepository clientRepository = new InMemoryClientRepositoryImpl();
        AdminsRepository adminsRepository = new InMemoryAdminRepositoryImpl();

        ClientService clientService = new ClientServiceImpl(bankRepository);
        LoginService loginService = new LoginServiceImpl(clientRepository, adminsRepository);

        router.addRoute("/", new IndexController());
        router.addRoute("/AdminLogin", new AdminLoginController(loginService));
        router.addRoute("/ClientLogin", new ClientLoginController(loginService));
        router.addRoute("/ClientLogin/Client", new UserController(clientService));
        router.addRoute("/AdminLogin/Admin", new AdminController());
        router.addRoute("/ClientLogin/Client/ChooseBank", new ChooseBank(clientService));
        router.addRoute("/ClientLogin/Client/GetAccount", new GetAccountController(clientService));
        router.addRoute("/ClientLogin/Client/Withdraw", new WithdrawController(clientService));
        router.addRoute("/ClientLogin/Client/Refill", new RefillController(clientService));
        router.addRoute("/ClientLogin/Client/Transfer", new TransferController(clientService));

        router.setEntryPoint(new IndexController());

        CreditAccountBuilder creditAccountBuilder = new CreditAccountBuilder();
        DepositAccountBuilder depositAccountBuilder = new DepositAccountBuilder();
        DebitAccountBuilder debitAccountBuilder = new DebitAccountBuilder();

        TimeManager timeManager = new DefaultTimeManagerImpl(LocalDateTime.now());

        clientRepository.createClient(new Client(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"), "name", "surname", "12345"));
        adminsRepository.createAdmin(new Admin(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"), "12345"));

        bankRepository.createBank(new Bank(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"),
                new GlobalFinancialMessagingService(new CentralBankService(), bankRepository),
                timeManager));

        bankRepository.getBankById(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"))
                .addAccount(creditAccountBuilder.setId(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"))
                        .setCurrentTime(timeManager.getCurrentTime())
                        .setLimit(new BigDecimal("10000"))
                        .setOwner(clientRepository.getClientById(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e")))
                        .setPassword("12345")
                        .setPercentage(new CreditPercentage(new BigDecimal("0.05")))
                        .createCreditAccount());

        while(true) {
            System.out.print(router.getCurrentController().getView().getView());
            PostForm form = router.getCurrentController().getView().sendPostRequest();
            RouteAction action = router.getCurrentController().processPostRequest(form);
            router.changeRoute(action);
        }
    }
}
