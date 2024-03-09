package org.banks.presentation.controllers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.models.Client;
import org.banks.corebusinessrules.services.ports.LoginService;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.actions.Stay;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.login.LoginView;

import java.util.UUID;

@RequiredArgsConstructor
public class ClientLoginController implements ConsoleController {
    private final LoginService loginService;
    @Override
    public ConsoleView GetView() {
        return new LoginView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        UUID id = UUID.fromString(form.getFormData().get("id"));
        String password = form.getFormData().get("password");
        Client client = loginService.ClientLogin(id, password);
        if(client != null) {
            return new Redirect("/ClientLogin/Client");
        }

        return new Stay("/");
    }
}
