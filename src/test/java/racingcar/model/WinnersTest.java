package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    @DisplayName("Winner 추가 테스트")
    void addWinner() {
        Winners winners = new Winners(new ArrayList<>());
        CarName carName = new CarName("abc");
        winners.addWinner(carName);

        assertEquals(1, winners.getWinnerList().size());
    }
}