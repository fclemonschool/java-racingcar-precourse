package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import lombok.extern.slf4j.Slf4j;
import racingcar.enums.InputType;

@Slf4j
public class IoUtils {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String INVALID_NAME_MESSAGE = "입력한 이름이 올바르지 않습니다.";
    private static final String INVALID_NUMBER_MESSAGE = "시도 횟수는 숫자여야 합니다.";

    private IoUtils() {
    }

    public static String getUserInput(String message) {
        log.info(message);
        return Console.readLine();
    }

    public static String getInvalidMessage(InputType inputType) {
        if (inputType == InputType.NAMES) {
            return ERROR_PREFIX + INVALID_NAME_MESSAGE;
        }
        return ERROR_PREFIX + INVALID_NUMBER_MESSAGE;
    }
}
