package homework2.competitionGame.obstacles;

import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;

public class SwimmingPool implements Obstacle{
    private final int distance;

    public SwimmingPool(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean pass(Participant participant) {
        return participant.getSwim() >= distance;
    }
}
