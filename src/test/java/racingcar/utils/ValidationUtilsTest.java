package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enums.InputType;

class ValidationUtilsTest {

    @Test
    @DisplayName("InputType NAMES 검증 테스트 - 이름 제한 글자 초과")
    void validateUserInputTypeNamesWithOverLength() {
        assertThatThrownBy(() -> ValidationUtils.validateUserInput(InputType.NAMES, "abc,def,ghssig")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("입력한 이름이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("InputType NAMES 검증 테스트 - 이름 미허용 특수 문자")
    void validateUserInputTypeNamesWithInvalidSpecialCharacter() {
        assertThatThrownBy(() -> ValidationUtils.validateUserInput(InputType.NAMES, "abc,def.ghss")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("입력한 이름이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("InputType NUMBERS 검증 테스트 - 시도 횟수 문자 입력")
    void validateUserInputTypeNumbersWithNotNumber() {
        assertThatThrownBy(() -> ValidationUtils.validateUserInput(InputType.NUMBERS, "a")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("시도 횟수는 숫자여야 합니다.");

    }
}