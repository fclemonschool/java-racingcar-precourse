package racingcar;

import java.util.HashMap;
import racingcar.model.Racing;
import racingcar.model.RacingResults;
import racingcar.model.Round;
import racingcar.model.UserInput;

public class Application {
    public static void main(String[] args) {
        new Racing(new UserInput(), new RacingResults(new HashMap<>()), new Round(0)).run();
    }
}
