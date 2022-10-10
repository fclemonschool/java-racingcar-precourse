package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @Test
    @DisplayName("CarName 파싱")
    void parseCarNames() {
        CarNames carNames = new CarNames(new HashSet<>());
        carNames.parseCarNames("abc,def");

        assertEquals(2, carNames.getCarNameSet().size());
    }
}