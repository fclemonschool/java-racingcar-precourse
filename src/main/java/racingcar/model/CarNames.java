package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarNames {
    private final Set<String> carNameSet;

    public CarNames(Set<String> carNameSet) {
        this.carNameSet = new HashSet<>(carNameSet);
    }

    public Set<String> getCarNameSet() {
        return Collections.unmodifiableSet(carNameSet);
    }

    void parseCarNames(String carNames) {
        if (carNames.contains(",")) {
            carNameSet.addAll(Arrays.asList(carNames.split(",")));
            return;
        }
        carNameSet.add(carNames);
    }
}
