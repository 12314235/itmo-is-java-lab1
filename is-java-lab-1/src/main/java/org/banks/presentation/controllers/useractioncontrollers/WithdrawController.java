package org.banks.presentation.controllers.useractioncontrollers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.presentation.controllers.ConsoleController;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.transactionview.TransactionView;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class WithdrawController implements ConsoleController {
    private final ClientService clientService;
    @Override
    public ConsoleView GetView() {
        return new TransactionView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        BigDecimal amount = new BigDecimal(form.getFormData().get("amount"));
        clientService.SendWithdrawOrder(amount);
        return new Redirect("/ClientLogin/Client");
    }
}
