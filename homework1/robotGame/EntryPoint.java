package homework1.robotGame;

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

// Homework
        // 0. Разобраться с проектом. Подготовить вопросы к следующему 
        // семинару, если возникнут
        // 1. Добавить валидацию при создании карты
        // 2. Реализовать возможность задать ограничение по количеству 
        // создаваемых на карте роботов (в конструкторе карты).
        // При этом если параметр не указан, то поставить по умолчанию 5
        // 3*. Реализовать возможность вызова метода move с параметром - 
        // количество шагов вперед
        // Подсказка можно несколько раз вызвать метод move

public class EntryPoint {
    public static void main(String[] args) {
        RobotMap map = new RobotMap(5, 5, 4);
        RobotMap.Robot robot = map.createRobot(new Point(2, 3));
        System.out.println(robot);
        // RobotMap.Robot robot1 = map.createRobot(new Point(1, 3));
        // System.out.println(robot1);
        // RobotMap.Robot robot2 = map.createRobot(new Point(0, 3));
        // System.out.println(robot2);
        // RobotMap.Robot robot3 = map.createRobot(new Point(0, 2));
        // System.out.println(robot2);
        // RobotMap.Robot robot4 = map.createRobot(new Point(0, 1));
        // System.out.println(robot2);
        // RobotMap.Robot robot5 = map.createRobot(new Point(0, 0));
        // System.out.println(robot2);
        
        // RobotMap.Robot robot1 = map.createRobot(new Point(2, 3));
        // System.out.println(robot1);
        robot.move(2);
        robot.changeDirection(Direction.RIGHT);
        robot.move();
    }
}