package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    private RandomUtils() {
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}
