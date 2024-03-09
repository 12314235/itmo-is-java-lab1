package org.banks.presentation.controllers;

import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;
import org.banks.presentation.routing.actions.Stay;
import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;
import org.banks.presentation.views.Index.IndexView;

public class IndexController implements ConsoleController {
    @Override
    public ConsoleView GetView() {
        return new IndexView();
    }

    @Override
    public RouteAction ProcessPostRequest(PostForm form) {
        return switch (form.getFormData().get("role")) {
            case "1" -> new Redirect("/AdminLogin");
            case "2" -> new Redirect("/ClientLogin");
            default -> new Stay("/");
        };
    }
}
