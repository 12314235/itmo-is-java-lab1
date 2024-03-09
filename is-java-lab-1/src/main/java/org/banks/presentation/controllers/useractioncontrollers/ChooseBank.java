package org.banks.presentation.controllers.useractioncontrollers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.presentation.controllers.ConsoleController;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.choosebank.ChooseBankView;

import java.util.UUID;

@RequiredArgsConstructor
public class ChooseBank implements ConsoleController {
    private final ClientService clientService;

    @Override
    public ConsoleView GetView() {
        return new ChooseBankView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        UUID id = UUID.fromString(form.getFormData().get("id"));
        clientService.ChooseBank(id);
        return new Redirect("/ClientLogin/Client");
    }
}
