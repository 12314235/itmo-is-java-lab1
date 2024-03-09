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
    public String GetView() {
        return this.View;
    }

    @Override
    public PostForm SendPostRequest() {
        PostForm form = new PostForm(new HashMap<>());
        Scanner scanner = new Scanner(System.in);
        form.AddData("amount", scanner.next());
        form.AddData("bankId", scanner.next());
        form.AddData("accountId", scanner.next());
        return form;
    }
}
