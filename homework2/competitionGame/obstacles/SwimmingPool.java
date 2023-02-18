package homework2.competitionGame.obstacles;

import homework2.competitionGame.interfaces.CanSwim;

public class SwimmingPool {
    private final int distance;

    public SwimmingPool(int distance) {
        this.distance = distance;
    }

    public boolean pass(CanSwim CanSwim) {
        return CanSwim.getSwim() >= distance;
    }
}
