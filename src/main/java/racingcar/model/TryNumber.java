package racingcar.model;

import lombok.Getter;

@Getter
public class TryNumber {
    private final String stringTryNumber;
    private final int intTryNumber;

    public TryNumber(String stringTryNumber) {
        this.stringTryNumber = stringTryNumber;
        this.intTryNumber = Integer.parseInt(stringTryNumber);
    }
}
