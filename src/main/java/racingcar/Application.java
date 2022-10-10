package racingcar;

import java.util.HashMap;
import racingcar.model.Racing;
import racingcar.model.UserInput;

public class Application {
    public static void main(String[] args) {
        new Racing(new UserInput(), new HashMap<>()).run();
    }
}
