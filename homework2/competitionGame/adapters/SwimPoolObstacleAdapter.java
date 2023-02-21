package homework2.competitionGame.adapters;

import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;
import homework2.competitionGame.obstacles.SwimmingPool;

public class SwimPoolObstacleAdapter implements Obstacle{
    private final SwimmingPool swimmingPool;

    public SwimPoolObstacleAdapter(SwimmingPool swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingPool.pass(participant);
    }
    
}
