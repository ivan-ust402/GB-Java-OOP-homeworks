package homework2.competitionGame.adapters;

import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;
import homework2.competitionGame.obstacles.Road;

public class RoadObstacleAdapter implements Obstacle{
    private final Road road;
    
    public RoadObstacleAdapter(Road road) {
        this.road = road;
    }

    @Override
    public boolean pass(Participant participant) {
        return road.pass(participant);
    }
    
}
