package org.banks.presentation.views.getaccount;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class GetAccountView extends ConsoleView {
    public GetAccountView() {
        super("Введите id и пароль: \n");
    }

    @Override
    public String getView() {
        return this.View;
    }

    @Override
    public PostForm sendPostRequest() {
        PostForm form = new PostForm(new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        form.addData("id", scanner.next());
        form.addData("password", scanner.next());
        return form;
    }
}
