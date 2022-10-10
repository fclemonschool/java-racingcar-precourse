package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Winners {
    private final List<String> winnerList;

    public Winners(List<String> winnerList) {
        this.winnerList = new ArrayList<>(winnerList);
    }

    public void add(String winner) {
        winnerList.add(winner);
    }

    public void noticeWinner() {
        log.info("최종 우승자 : " + String.join(", ", winnerList));
    }
}
