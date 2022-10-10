package racingcar.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RacingResults {
    private final Map<String, StringBuilder> racingResultsMap;

    public RacingResults(Map<String, StringBuilder> racingResultsMap) {
        this.racingResultsMap = new HashMap<>(racingResultsMap);
    }

    public Map<String, StringBuilder> getRacingResultsMap() {
        return Collections.unmodifiableMap(racingResultsMap);
    }

    public void initialize(CarNames carNames) {
        carNames.getCarNameSet().forEach(carName -> racingResultsMap.put(carName, new StringBuilder()));
    }

    public void addRacingResult(String carName, StringBuilder carResult) {
        racingResultsMap.put(carName, carResult);
        log.info(carName + " : " + carResult);
    }
}
