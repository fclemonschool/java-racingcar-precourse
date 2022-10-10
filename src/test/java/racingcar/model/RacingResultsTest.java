package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultsTest {

    @Test
    @DisplayName("initialize 테스트")
    void initialize() {
        CarNames carNames = new CarNames(new HashSet<>());
        carNames.parseCarNames("abc,def");
        RacingResults racingResults = new RacingResults(new HashMap<>());
        racingResults.initialize(carNames);

        assertEquals(2, racingResults.getRacingResultsMap().size());
    }

    @Test
    @DisplayName("add 테스트")
    void addRacingResult() {
        RacingResults racingResults = new RacingResults(new HashMap<>());
        racingResults.addRacingResult(new CarName("abc"), new StringBuilder());

        assertEquals(1, racingResults.getRacingResultsMap().size());
    }
}