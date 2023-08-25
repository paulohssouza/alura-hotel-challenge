package br.com.phss.model.service;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class FormsConfiguration {
    public static void limitTextField(TextField textField, int limit) {
        UnaryOperator<TextFormatter.Change> textLimitFilter = change -> {
            if (change.isContentChange()) {
                int newLength = change.getControlNewText().length();
                if (newLength > limit) {
                    String trimmedText = change.getControlNewText().substring(0, limit);
                    change.setText(trimmedText);
                    int oldLength = change.getControlText().length();
                    change.setRange(0, oldLength);
                }
            }
            return change;
        };
        textField.setTextFormatter(new TextFormatter<>(textLimitFilter));
    }
}
