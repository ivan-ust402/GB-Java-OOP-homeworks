package homework2.roundHoleMachine;

import homework2.roundHoleMachine.adapter.SquarePegAdapter;
import homework2.roundHoleMachine.hole.RoundHoleClass;
import homework2.roundHoleMachine.pegs.RoundPegClass;
import homework2.roundHoleMachine.pegs.SquarePegClass;

    // 3. *Есть интерфейс RoundHole - описание круглое отверстия (имеет радиус) double getRadius()
    // Есть интерфейс RoundPeg - описание круглого колышка (тоже есть радиус)
    // Есть класс RoundHoleMachine, у которой метод, принмает RoundPeg, возвращает RoundHole
    // Есть интерфейс SquarePeg - описание квадратного колышка (имеет длину стороны кварата)
    // Реализовать адаптер для SquarePeg в RoundHoleMachine 

public class MainProg {
    public static void main(String[] args) {
/*         RoundHoleMachine firstMachine = new RoundHoleMachine();
        RoundPegClass firstRoundPeg = new RoundPegClass(4);
        RoundHoleClass firstRoundHole = firstMachine.createHole(firstRoundPeg);
        System.out.println("Сделано отверстие радиуса: " + firstRoundHole.getRadius() + " для колышка радиусом: " + firstRoundPeg.getRadius());

        RoundHoleMachine secondMachine = new RoundHoleMachine();
        SquarePegClass secondSquarePeg = new SquarePegClass(4);
        RoundHoleClass secondRoundHole = secondMachine.createHole(new SquarePegAdapter(secondSquarePeg));
        System.out.println("Сделано отверстие радиуса: " + secondRoundHole.getRadius() + " для квадратного колышка со строной: " + secondSquarePeg.getSide()); */

        RoundHoleClass[] roundHoles = createHoleForRoundPeg();
        RoundHoleClass[] squareHoles = createHoleForSquarePeg();
        printInfo(squareHoles, "Квадратный колышек");
        printInfo(roundHoles, "Круглый колышек");
        
    }

    private static RoundHoleClass[] createHoleForRoundPeg() {
        return new RoundHoleClass[] {
            new RoundHoleMachine().createHole(new RoundPegClass(1)),
            new RoundHoleMachine().createHole(new RoundPegClass(2)),
            new RoundHoleMachine().createHole(new RoundPegClass(3)),
            new RoundHoleMachine().createHole(new RoundPegClass(5)),
            new RoundHoleMachine().createHole(new RoundPegClass(8)),
            new RoundHoleMachine().createHole(new RoundPegClass(13)),
        };
    }

    private static RoundHoleClass[] createHoleForSquarePeg() {
        return new RoundHoleClass[] {
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(1))),
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(2))),
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(3))),
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(5))),
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(8))),
            new RoundHoleMachine().createHole(new SquarePegAdapter(new SquarePegClass(13))),
        };
    }

    private static void printInfo(RoundHoleClass[] holes, String name) {
        for (RoundHoleClass hole : holes) {
            String result = String.format("%.2f", hole.getRadius());
            System.out.println(name + ", радиус отверстия для колышка: " + result);
        }
    }
}
