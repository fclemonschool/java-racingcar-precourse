package racingcar.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import racingcar.utils.RandomUtils;

@Slf4j
public class Racing {
    private final UserInput userInput;
    private Winners winners;
    private final RacingResults racingResults;
    private int round = 0;
    private static final int MOVING_FORWARD = 4;

    public Racing(UserInput userInput, RacingResults racingResults) {
        this.userInput = userInput;
        this.racingResults = racingResults;
    }

    public void run() {
        racingResults.initialize(userInput.getCarNames());
        log.info("실행결과");
        while (round < userInput.getTryNumber()) {
            racingResults.getRacingResultsMap().forEach(this::tryRound);
            log.info("\n");
            round++;
        }
        calculateWinners();
        winners.noticeWinner();
    }

    private void tryRound(String carName, StringBuilder racingResult) {
        racingResults.addRacingResult(carName, racingResult.append(tryGoOrStop()));
    }

    private String tryGoOrStop() {
        int randomNumber = RandomUtils.generateRandomNumber();
        if (randomNumber >= MOVING_FORWARD) {
            return "-";
        }
        return "";
    }

    private void calculateWinners() {
        int maxValue = 0;
        for (Entry<String, StringBuilder> entry : racingResults.getRacingResultsMap().entrySet()) {
            maxValue = setWinnersAndUpdateMaxValue(maxValue, entry.getKey(), entry.getValue());
        }
    }

    private int setWinnersAndUpdateMaxValue(int maxValue, String car, StringBuilder value) {
        if (maxValue < value.length()) {
            maxValue = value.length();
            winners = new Winners(new ArrayList<>());
        }
        if (maxValue == value.length()) {
            winners.addWinner(car);
        }
        return maxValue;
    }
}
