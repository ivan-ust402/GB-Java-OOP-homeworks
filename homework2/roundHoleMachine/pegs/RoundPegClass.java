package homework2.roundHoleMachine.pegs;

import homework2.roundHoleMachine.interfaces.RoundPeg;

public class RoundPegClass implements RoundPeg{
    private final double radius;

    public RoundPegClass(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }
    
}
