package org.banks.presentation.routing.actions;

import lombok.Data;


public class Redirect extends RouteAction {
    public Redirect(String newRoute) {
        super(newRoute);
    }
}
