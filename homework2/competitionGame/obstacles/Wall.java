package homework2.competitionGame.obstacles;

import homework2.competitionGame.interfaces.CanJump;

public class Wall {
    private final int height;

    public Wall(int height){
        this.height = height;
    }

    public boolean pass(CanJump canJump) {
        return canJump.getJump() >= height;
    }
}
