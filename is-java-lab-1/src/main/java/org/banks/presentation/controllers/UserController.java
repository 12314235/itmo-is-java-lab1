package org.banks.presentation.controllers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.services.ports.ClientService;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.actions.Stay;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.client.ClientView;

@RequiredArgsConstructor
public class UserController implements ConsoleController {
    private final ClientService clientService;

    @Override
    public ConsoleView getView() {
        return new ClientView();
    }

    @Override
    public RouteAction processPostRequest(PostForm form) {
        return switch(form.getFormData().get("operation")) {
            case "1" -> new Redirect("/ClientLogin/Client/ChooseBank");
            case "2" -> new Redirect("/ClientLogin/Client/GetAccount");
            case "3" -> new Redirect("/ClientLogin/Client/");
            case "4" -> new Redirect("/ClientLogin/Client/Withdraw");
            case "5" -> new Redirect("/ClientLogin/Client/Refill");
            case "6" -> new Redirect("/ClientLogin/Client/Transfer");
            default -> new Stay("");
        };
    }
}
