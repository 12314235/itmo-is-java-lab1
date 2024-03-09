package org.banks.presentation.views.transactionview;

import org.banks.presentation.routing.forms.PostForm;
import org.banks.presentation.views.ConsoleView;

import java.util.HashMap;
import java.util.Scanner;

public class TransactionView extends ConsoleView {
    public TransactionView() {
        super("Введите сумму: ");
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
        return form;
    }
}
