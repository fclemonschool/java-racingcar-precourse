package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("다음 라운드 가능 여부 테스트 및 라운드 진행 테스트")
    void hasNextRound() {
        Round round = new Round(0);
        round.nextRound();
        assertFalse(round.hasNextRound(1));
    }
}