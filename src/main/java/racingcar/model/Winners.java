package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Winners {
    private final List<CarName> winnerList;

    public Winners(List<CarName> winnerList) {
        this.winnerList = new ArrayList<>(winnerList);
    }

    public void addWinner(CarName winner) {
        winnerList.add(winner);
    }

    public List<CarName> getWinnerList() {
        return Collections.unmodifiableList(winnerList);
    }

    public void noticeWinner() {
        StringBuilder noticeBuilder = new StringBuilder();
        for (int i = 0; i < winnerList.size(); i++) {
            makeNotice(noticeBuilder, i);
        }
        log.info("최종 우승자 : " + noticeBuilder);
    }

    private void makeNotice(StringBuilder noticeBuilder, int i) {
        CarName winner = winnerList.get(i);
        noticeBuilder.append(winner.getName());
        if (i != winnerList.size() - 1) {
            noticeBuilder.append(",");
        }
    }
}
