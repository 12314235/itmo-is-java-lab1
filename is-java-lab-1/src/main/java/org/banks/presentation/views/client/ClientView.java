package org.banks.presentation.views.client;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class ClientView extends ConsoleView {

    public ClientView() {
        super("Выберите операцию: \n" +
                "1. Выбрать банк\n" +
                "2. Получить доступ к счету\n" +
                "3. Создать счет\n" +
                "4. Снять\n" +
                "5. Пополнить\n" +
                "6. Перевести\n" +
                "7. Выход");
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
