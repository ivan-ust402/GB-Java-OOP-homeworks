package homework2.competitionGame.adapters;

import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;
import homework2.competitionGame.obstacles.Mountain;

public class MountainObstacleAdapter implements Obstacle{
    private final Mountain mountain;

    public MountainObstacleAdapter(Mountain mountain) {
        this.mountain = mountain;
    }

    @Override
    public boolean pass(Participant participant) {
        return mountain.pass(participant);
    }
    
}
