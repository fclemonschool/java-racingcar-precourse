package racingcar.utils;

import java.util.regex.Pattern;
import racingcar.enums.InputType;

public class ValidationUtils {
    private static final Pattern validSingleCarNamePattern = Pattern.compile("^[a-zA-Z]{1,5}+$");
    private static final Pattern invalidMultipleCarNamePattern = Pattern.compile("^[^a-zA-Z,]+$");

    private ValidationUtils() {
    }

    public static void validateUserInput(InputType inputType, String input) {
        if (inputType == InputType.NAMES) {
            validateInputStringIsCarNames(input, inputType);
            return;
        }
        validateInputStringIsInteger(input, inputType);
    }

    private static void validateInputStringIsCarNames(String input, InputType inputType) {
        if (!validSingleCarNamePattern.matcher(input).matches() || invalidMultipleCarNamePattern.matcher(input)
                .matches()) {
            throw new IllegalArgumentException(IoUtils.getInvalidMessage(inputType));
        }
    }

    private static void validateInputStringIsInteger(String input, InputType inputType) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IoUtils.getInvalidMessage(inputType));
        }
    }
}
