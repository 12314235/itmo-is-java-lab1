package org.banks.presentation.controllers;

import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

public interface ConsoleController {
    public ConsoleView GetView();
    public RouteAction ProcessPostRequest(PostForm form);
}
