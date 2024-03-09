package org.banks.presentation.views;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.banks.presentation.routing.forms.PostForm;

@RequiredArgsConstructor
public abstract class ConsoleView {
    protected final String View;

    public abstract String GetView();
    public abstract PostForm SendPostRequest();
}
