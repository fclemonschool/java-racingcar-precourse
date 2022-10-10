package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CarNames {
    private final Set<CarName> carNameSet;

    public CarNames(Set<CarName> carNameSet) {
        this.carNameSet = new HashSet<>(carNameSet);
    }

    public Set<CarName> getCarNameSet() {
        return Collections.unmodifiableSet(carNameSet);
    }

    void parseCarNames(String carNames) {
        if (carNames.contains(",")) {
            carNameSet.addAll(Arrays.asList(makeCarNameArray(carNames.split(","))));
            return;
        }
        carNameSet.add(new CarName(carNames));
    }

    private static CarName[] makeCarNameArray(String[] namesArray) {
        CarName[] carNameArray = new CarName[namesArray.length];
        for (int i = 0; i < namesArray.length; i++) {
            carNameArray[i] = new CarName(namesArray[i]);
        }
        return carNameArray;
    }
}
