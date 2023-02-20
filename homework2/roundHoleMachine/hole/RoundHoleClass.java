package homework2.roundHoleMachine.hole;

import homework2.roundHoleMachine.interfaces.RoundHole;

public class RoundHoleClass implements RoundHole{
    private final double radius;

    public RoundHoleClass(double radius) {
        this.radius = radius;
    }
    

    @Override
    public double getRadius() {
        return radius;
    }
}
