package homework5;

import java.util.Optional;

/*
 * Перечисление направления движений робота
 */
public enum Direction {
    TOP, RIGHT, BOTTOM, LEFT;

    public static Optional<Direction> ofString (String str) {
        for (Direction value : values()) {
            if (str.equals(value.name())){
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
