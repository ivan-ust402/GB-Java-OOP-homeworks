package homework2.roundHoleMachine.pegs;

import homework2.roundHoleMachine.interfaces.SquarePeg;

public class SquarePegClass implements SquarePeg{
    private final double side;

    public SquarePegClass(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    
}
