package de.einjojo.target.util;

public enum Placeholder {
    PLAYER("%player%"),
    PREFIX("%prefix%");

    private final String string;

    Placeholder(String placeholder) {
        this.string = placeholder;
    }

    public static String replace(Placeholder placeholder, String message, String replacement) {
        return message.replace(placeholder.string, replacement);
    }
}
