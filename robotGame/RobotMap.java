package robotGame;

public class RobotMap {
    private final int n;
    private final int m;

    RobotMap(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public Robot createRobot(Point point) {
        Robot robot = new Robot(point);
        return robot;
    }

    public class Robot {
        private Point point;

        public Robot(Point point) {
            this.point = point;
        }

        public void changeDirection() {
            
        }

        public void move() {
            final Point newPoint;

        }
    }
}
