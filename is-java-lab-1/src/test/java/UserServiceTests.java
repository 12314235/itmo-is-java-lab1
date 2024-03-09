import org.banks.corebusinessrules.bank.Bank;
import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.services.centralbankservice.CentralBankService;
import org.banks.corebusinessrules.services.globalfinancialmessagingservice.GlobalFinancialMessagingService;
import org.banks.corebusinessrules.services.repositories.AdminsRepository;
import org.banks.corebusinessrules.services.repositories.BankRepository;
import org.banks.corebusinessrules.services.repositories.ClientRepository;
import org.banks.corebusinessrules.services.timemanager.DefaultTimeManagerImpl;
import org.banks.datalayer.InMemoryAdminRepositoryImpl;
import org.banks.datalayer.InMemoryBankRepositoryImpl;
import org.banks.datalayer.InMemoryClientRepositoryImpl;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserServiceTests {
    BankRepository bankRepository = new InMemoryBankRepositoryImpl();
    ClientRepository clientRepository = new InMemoryClientRepositoryImpl();
    AdminsRepository adminsRepository = new InMemoryAdminRepositoryImpl();

    @Test
    public void Test() {
        clientRepository.CreateClient(new Client(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"), "name", "surname", "12345"));
        adminsRepository.CreateAdmin(new Admin(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"), "12345"));

        bankRepository.CreateBank(new Bank(UUID.fromString("f5fc9860-1e9f-4cf1-8213-5e2c122ece6e"),
                new GlobalFinancialMessagingService(new CentralBankService(), bankRepository),
                new DefaultTimeManagerImpl(LocalDateTime.now())));


    }
}
