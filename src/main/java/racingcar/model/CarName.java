package racingcar.model;

import lombok.Getter;

@Getter
public class CarName {
    private final String name;

    public CarName(String name) {
        this.name = name;
    }
}
