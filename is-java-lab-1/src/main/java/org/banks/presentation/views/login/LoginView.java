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
    public String GetView() {
        return this.View;
    }

    @Override
    public PostForm SendPostRequest() {
        PostForm form = new PostForm(new HashMap<String, String>());
        Scanner scanner = new Scanner(System.in);
        form.AddData("id", scanner.next());
        form.AddData("password", scanner.next());
        return form;
    }
}
