package org.banks.presentation.routing;

import lombok.Getter;
import org.banks.presentation.controllers.ConsoleController;
import org.banks.presentation.routing.actions.Redirect;
import org.banks.presentation.routing.actions.RouteAction;

import java.util.HashMap;
import java.util.Map;

public class DumbRouter {
    private Map<String, ConsoleController> routes = new HashMap<>();
    @Getter private ConsoleController currentController;

    public void addRoute(String route, ConsoleController controller) {
        routes.put(route, controller);
    }

    public void setEntryPoint(ConsoleController controller) {
        this.currentController = controller;
    }

    public void changeRoute(RouteAction action) {
        if(action instanceof Redirect) {
            this.currentController = this.routes.get(action.getNewRoute());
        }
    }
}
