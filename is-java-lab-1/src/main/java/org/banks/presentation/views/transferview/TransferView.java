package org.banks.presentation.views.transferview;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class TransferView extends ConsoleView {

    public TransferView() {
        super("Введите сумму, id банка, id аккаунта: ");
    }

    @Override
    public String getView() {
        return this.View;
    }

    @Override
    public PostForm sendPostRequest() {
        PostForm form = new PostForm(new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        form.addData("amount", scanner.next());
        form.addData("bankId", scanner.next());
        form.addData("accountId", scanner.next());
        return form;
    }
}
