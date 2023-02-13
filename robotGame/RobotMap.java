package robotGame;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {
    private final int n;
    private final int m;
    private final int robotCount;

    private final List<Robot> robots;

    /*
     * Конструктор класса RobotMap
     */
    public RobotMap(int n, int m, int robotCount) {
        validateRobotMapBoundaries(n, m);
        this.n = n;
        this.m = m;
        validateInputRobotCount(n, m, robotCount);
        this.robotCount = robotCount;
        this.robots = new ArrayList<>();
    }

    /*
     * Перегрузка конструктора
     */
    public RobotMap(int n, int m) {
        this(n, m, 5);
    }

    /*
     * Валидация размерности карты
     */
    private void validateRobotMapBoundaries(int n, int m) {
        if (n <= 0 || m <=0) {
            throw new IllegalStateException("Некорректная размерность карты!");
        }
    }

    /*
     * Валидация значения количества роботов на карте
     */
    private void validateInputRobotCount(int n, int m, int count) {
        if (count <= 0) {
            throw new IllegalStateException("Количество роботов не может быть отрицательным или равно нулю");
        }
        if (count > m * n) {
            throw new IllegalStateException("Число роботов не может превышать количества ячеек карты:\n " + "максимальное количество роботов: " +
            (n * m) + ", ваше число роботов: " + count);
        }
    }

    /*
     * Создание экземпляра робота
     */
    public Robot createRobot(Point point) {
        validatePoint(point);
        validateCreateRobotCount(robots, robotCount);
        Robot robot = new Robot(point);
        robots.add(robot);
        return robot;
    }

    /*
     * Валидация количества роботов при создании экземпляров
     */
    private void validateCreateRobotCount(List<Robot> robots, int count) {
        if (robots.size() >= count) {
            throw new IllegalStateException(
                "Нельзя добавить еще одного робота!\n" + 
                "Данный робот будет " + 
                (robots.size() + 1) + " из допустимых " +
                robotCount
                );
        }
    }

    /*
     * Валидация точки
     */
    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    /*
     * Валидация на корректные координаты точки
     */
    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некорректное значение точки!\n Точка находится за пределами игрового поля");
        }
    }

    /*
     * Валидация на незанятую точку
     */
    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            if (robot.point.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    /*
     * Вложенный класс Robot
     */
    public class Robot {
        public static final Direction DEFAUL_DIRECTION = Direction.TOP;
        private Direction direction;
        private Point point;

        /*
         * Конструктор класса Robot
         */
        public Robot(Point point) {
            this.direction = DEFAUL_DIRECTION;
            this.point = point;
        }

        /*
         * Метод смены направления движения
         */
        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        /*
         * Метод движения робота
         */
        public void move() {
            move(1);
        }

        /*
         * Перегрузка метода движения робота
         */
        public void move(int step) {
            System.out.println("Количество шагов: " + step );
            for (int i = 0; i < step; i++) {
                final Point newPoint;
                switch(direction) {
                    case TOP: newPoint = new Point(point.x() - 1, point.y());
                              break;
                    case RIGHT: newPoint = new Point(point.x(), point.y() + 1);
                              break;
                    case BOTTOM: newPoint = new Point(point.x() + 1, point.y());
                              break;
                    case LEFT: newPoint = new Point(point.x(), point.y() - 1);
                              break;
                    default: newPoint = new Point(point.x(), point.y());
                }
                validatePoint(newPoint);
                System.out.println("Робот переместился с " + point + " на " + newPoint);
                this.point = newPoint;
            }
        }

        /*
         * Переобределение метода toString
         */
        @Override
        public String toString() {
            return point.toString() + ", ["+ direction.name() + "]";
        }
    }
}
