package org.banks.presentation.views.Index;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class IndexView extends ConsoleView {
    public IndexView() {
        super("Войти как: \n" +
                "1. Admin\n" +
                "2. Client\n" +
                "Введите цифру: ");
    }

    @Override
    public String getView() {
        return this.View;
    }

    @Override
    public PostForm sendPostRequest() {
        Scanner scanner = new Scanner(System.in);
        PostForm form = new PostForm(new HashMap<>());
        form.addData("role", scanner.next());
        return form;
    }
}
