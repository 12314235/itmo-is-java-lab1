package org.banks.presentation.views.admin;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;


public class AdminView extends ConsoleView {
    public AdminView() {
        super("Выберите операцию: \n" +
                "1. Создать банк\n" +
                "2. Обновить условия банка\n" +
                "Введите номер операции: ");
    }

    @Override
    public String getView() {
        return this.View;
    }

    @Override
    public PostForm sendPostRequest() {
        PostForm form = new PostForm(new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        form.addData("operation", scanner.next());
        return form;
    }
}
