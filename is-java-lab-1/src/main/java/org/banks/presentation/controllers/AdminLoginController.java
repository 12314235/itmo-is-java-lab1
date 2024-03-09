package org.banks.presentation.controllers;

import lombok.RequiredArgsConstructor;
import org.banks.corebusinessrules.models.Admin;
import org.banks.corebusinessrules.services.ports.LoginService;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.actions.Stay;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.login.LoginView;

import java.util.UUID;

@RequiredArgsConstructor
public class AdminLoginController implements ConsoleController {
    private final LoginService loginService;
    @Override
    public ConsoleView GetView() {
        return new LoginView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        UUID id = UUID.fromString(form.getFormData().get("id"));
        String password = form.getFormData().get("password");
        Admin admin = loginService.AdminLogin(id, password);
        if(admin != null) {
            return new Redirect("/AdminLogin/Admin");
        }

        return new Stay("/");
    }
}
