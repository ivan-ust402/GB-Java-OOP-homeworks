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
        public static final Direction DEFAUL_DIRECTION = Direction.TOP;
        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAUL_DIRECTION;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
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
            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return point.toString() + ", ["+ direction.name() + "]";
        }
    }
}
