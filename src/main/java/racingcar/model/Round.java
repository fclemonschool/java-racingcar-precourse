package racingcar.model;

public class Round {
    private int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void nextRound() {
        this.roundNumber++;
    }

    public boolean hasNextRound(int tryNumber) {
        return roundNumber < tryNumber;
    }
}
