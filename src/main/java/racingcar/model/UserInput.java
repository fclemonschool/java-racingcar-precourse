package racingcar.model;

import java.util.HashSet;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import racingcar.enums.InputType;
import racingcar.utils.IoUtils;
import racingcar.utils.ValidationUtils;

@Slf4j
@Getter
public class UserInput {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    private static final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private CarNames carNames;
    private Integer tryNumber;

    public UserInput() {
        getUserInputWithValidationAndSetCarNames();
        getUserInputWithValidationAndSetTryNumber();
    }

    private void getUserInputWithValidationAndSetCarNames() {
        try {
            String names = IoUtils.getUserInput(CAR_INPUT_MESSAGE);
            ValidationUtils.validateUserInput(InputType.NAMES, names);
            carNames = new CarNames(new HashSet<>());
            carNames.parseCarNames(names);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            getUserInputWithValidationAndSetCarNames();
        }
    }

    private void getUserInputWithValidationAndSetTryNumber() {
        try {
            String stringTryNumber = IoUtils.getUserInput(TRY_INPUT_MESSAGE);
            ValidationUtils.validateUserInput(InputType.NUMBERS, stringTryNumber);
            tryNumber = Integer.parseInt(stringTryNumber);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            getUserInputWithValidationAndSetTryNumber();
        }
    }
}
