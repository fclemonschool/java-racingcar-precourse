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
    private final Round round;
    private static final int MOVING_FORWARD = 4;

    public Racing(UserInput userInput, RacingResults racingResults, Round round) {
        this.userInput = userInput;
        this.racingResults = racingResults;
        this.round = round;
    }

    public void run() {
        racingResults.initialize(userInput.getCarNames());
        log.info("실행결과");
        while (round.hasNextRound(userInput.getTryNumber().getIntTryNumber())) {
            racingResults.getRacingResultsMap().forEach(this::tryRound);
            log.info("\n");
            round.nextRound();
        }
        calculateWinners();
        winners.noticeWinner();
    }

    private void tryRound(CarName carName, StringBuilder racingResult) {
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
        for (Entry<CarName, StringBuilder> entry : racingResults.getRacingResultsMap().entrySet()) {
            maxValue = setWinnersAndUpdateMaxValue(maxValue, entry.getKey(), entry.getValue());
        }
    }

    private int setWinnersAndUpdateMaxValue(int maxValue, CarName carName, StringBuilder value) {
        if (maxValue < value.length()) {
            maxValue = value.length();
            winners = new Winners(new ArrayList<>());
        }
        if (maxValue == value.length()) {
            winners.addWinner(carName);
        }
        return maxValue;
    }
}
