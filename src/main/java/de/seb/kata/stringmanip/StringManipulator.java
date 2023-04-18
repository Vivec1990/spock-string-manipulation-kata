package de.seb.kata.stringmanip;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringManipulator {

    public static String format(final String text, final FormatOption format) {
        switch (format) {
            case ALL_UPPER -> {
                return text.toUpperCase();
            }
            case ALL_LOWER -> {
                return text.toLowerCase();
            }
            case CAMEL_CASE -> {
                return Arrays.stream(text.split(" "))
                        .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                        .collect(Collectors.joining(" "));
            }
            case ALTERNATING -> {
                return alternating(text, false);
            }
            case DIFF_ALTERNATING -> {
                return alternating(text, true);
            }
            case ALTERNATING_WORD -> {
                return alternatingWord(text, false);
            }
            case DIFF_ALTERNATING_WORD -> {
                return alternatingWord(text, true);
            }
            default -> {
                return null;
            }
        }
    }

    private static String alternatingWord(String text, boolean toUpper) {
        final var result = new StringBuilder();
        for (String s : text.split(" ")) {
            result.append(toUpper ? s.toUpperCase() : s.toLowerCase()).append(" ");
            toUpper = !toUpper;
        }
        return result.toString().trim();
    }

    private static String alternating(String text, boolean toUpper) {
        final var result = new StringBuilder();
        for (String s : text.split("")) {
            if (s.equals(" ")) {
                result.append(s);
            } else {
                result.append(toUpper ? s.toUpperCase() : s.toLowerCase());
                toUpper = !toUpper;
            }
        }
        return result.toString();
    }

}
