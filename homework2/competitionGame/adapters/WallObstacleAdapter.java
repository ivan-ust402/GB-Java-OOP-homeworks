package homework2.competitionGame.adapters;

import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;
import homework2.competitionGame.obstacles.Wall;

public class WallObstacleAdapter implements Obstacle{
    private final Wall wall;

    public WallObstacleAdapter(Wall wall) {
        this.wall = wall;
    }

    @Override
    public boolean pass(Participant participant) {
        return wall.pass(participant);
    }
}
