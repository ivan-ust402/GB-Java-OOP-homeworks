package homework2.roundHoleMachine.adapter;

import homework2.roundHoleMachine.interfaces.RoundPeg;
import homework2.roundHoleMachine.interfaces.SquarePeg;

public class SquarePegAdapter implements RoundPeg{
    private final SquarePeg squarePeg;

    public SquarePegAdapter (SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return squarePeg.getSide() * Math.sqrt(2) / 2;
    }
}
