package org.banks.presentation.views;

import lombok.RequiredArgsConstructor;
import org.banks.presentation.routing.forms.PostForm;

@RequiredArgsConstructor
public abstract class ConsoleView {
    protected final String View;

    public abstract String getView();
    public abstract PostForm sendPostRequest();
}
