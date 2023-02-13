package robotGame;

/**
 * main - entry point
 */

// Карта с роботами.
// Карта имеет размер nxm, где n и m - положительные целые числа
// Должна быть возможность создания робота на какой-то точке на
// карте
// Координата робота - точка на карте описывается двумя 
// целочисленными координатами.
// Роботы могут перемещаться по карте вперед
// В одной точке не может находится несколько роботов.


/*
* * * * *
* * r * *
* * * * *
* * * * * 
* * * * * 
*/
public class EntryPoint {
    public static void main(String[] args) {
        RobotMap map = new RobotMap(5, 5);
        RobotMap.Robot robot = map.createRobot(new Point(2, 3));
        System.out.println(robot);
        RobotMap.Robot robot1 = map.createRobot(new Point(2, 3));
        System.out.println(robot1);
        robot.move();
        robot.move();
        robot.changeDirection(Direction.RIGHT);
        robot.move();
    }
}