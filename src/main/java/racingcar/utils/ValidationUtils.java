package racingcar.utils;

import java.util.regex.Pattern;
import racingcar.enums.InputType;

public class ValidationUtils {
    private static final Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");
    private static final Pattern invalidSpecialCharacterPattern = Pattern.compile("[^a-zA-Z,]+");
    private static final int MAX_NAME_LENGTH = 5;

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
        if (specialCharacterPattern.matcher(input).find()) {
            throwExceptionByCondition(invalidSpecialCharacterPattern.matcher(input).find(), inputType);
            for (String name : input.split(",")) {
                throwExceptionByCondition(name.length() > MAX_NAME_LENGTH, inputType);
            }
            return;
        }
        throwExceptionByCondition(input.length() > MAX_NAME_LENGTH, inputType);
    }

    private static void throwExceptionByCondition(boolean condition, InputType inputType) {
        if (condition) {
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
