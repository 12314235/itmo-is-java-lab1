package org.banks.presentation.views.login;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class LoginView extends ConsoleView {
    public LoginView() {
        super("Введите id и пароль: \n");
    }

    @Override
    public String getView() {
        return this.View;
    }

    @Override
    public PostForm sendPostRequest() {
        PostForm form = new PostForm(new HashMap<String, String>());
        Scanner scanner = new Scanner(System.in);
        form.addData("id", scanner.next());
        form.addData("password", scanner.next());
        return form;
    }
}
