package homework2.roundHoleMachine;


import homework2.roundHoleMachine.hole.RoundHoleClass;
import homework2.roundHoleMachine.interfaces.RoundPeg;
    
public class RoundHoleMachine {
    public RoundHoleClass createHole(RoundPeg roundPeg) {
        return new RoundHoleClass(roundPeg.getRadius()); 
    }
}