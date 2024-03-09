package org.banks.presentation.views.choosebank;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class ChooseBankView extends ConsoleView {
    public ChooseBankView() {
        super("Введите id банка: ");
    }

    @Override
    public String GetView() {
        return this.View;
    }

    @Override
    public PostForm SendPostRequest() {
        PostForm form = new PostForm(new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        form.AddData("id", scanner.next());
        return form;
    }
}