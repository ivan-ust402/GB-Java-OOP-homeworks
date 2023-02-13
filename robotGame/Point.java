package robotGame;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;
    
    /*
     * Конструктор класса Point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * Метод получения координаты x
     */
    public int x() {
        return x;
    }
    
    /*
     * Метод получения координаты x
     */
    public int y() {
        return y;
    }

    /*
     * Переопределение метода toString
     */
    @Override
    public String toString() {
        return "(" + x + ", " +  y + ")";
    }

    /*
     * Переопределение метода equals
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    /*
     * Переопределение метода hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
