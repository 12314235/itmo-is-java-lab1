package org.banks.presentation.controllers.useractioncontrollers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.presentation.controllers.ConsoleController;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.transactionview.TransactionView;
import org.banks.presentation.views.transferview.TransferView;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
public class TransferController implements ConsoleController {
    private final ClientService clientService;
    @Override
    public ConsoleView GetView() {
        return new TransferView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        BigDecimal amount = new BigDecimal(form.getFormData().get("amount"));
        UUID bankId = UUID.fromString(form.getFormData().get("bankId"));
        UUID accountId = UUID.fromString(form.getFormData().get("accountId"));
        clientService.SendTransferOrder(bankId, accountId, amount);
        return new Redirect("/ClientLogin/Client");
    }
}
