package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    @DisplayName("랜덤 넘버 생성 후 동일성 테스트")
    void generateRandomNumber() {
        int first = RandomUtils.generateRandomNumber();
        int second = RandomUtils.generateRandomNumber();
        int third = RandomUtils.generateRandomNumber();
        int fourth = RandomUtils.generateRandomNumber();
        int fifth = RandomUtils.generateRandomNumber();

        assertFalse(first == second && second == third && third == fourth && fourth == fifth);
    }
}