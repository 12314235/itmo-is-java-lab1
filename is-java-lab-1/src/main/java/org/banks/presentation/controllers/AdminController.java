package org.banks.presentation.controllers;

import org.banks.application.servicesimplementations.AdminServiceImpl;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.admin.AdminView;

public class AdminController implements ConsoleController {
    @Override
    public ConsoleView GetView() {
        return new AdminView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        return null;
    }
}
