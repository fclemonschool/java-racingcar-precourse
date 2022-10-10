package racingcar;

import racingcar.model.Racing;
import racingcar.model.UserInput;

public class Application {
    public static void main(String[] args) {
        new Racing(new UserInput()).run();
    }
}
