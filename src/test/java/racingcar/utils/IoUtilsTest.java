package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enums.InputType;

class IoUtilsTest {

    @Test
    @DisplayName("에러 메시지 생성 테스트")
    void getInvalidMessage() {
        assertEquals("[ERROR] 시도 횟수는 숫자여야 합니다.", IoUtils.getInvalidMessage(InputType.NUMBERS));
        assertEquals("[ERROR] 입력한 이름이 올바르지 않습니다.", IoUtils.getInvalidMessage(InputType.NAMES));
    }
}