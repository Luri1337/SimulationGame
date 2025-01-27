package Utils;

import java.util.Objects;

public class Coordinates {
    public final Integer x;
    public final Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Coordinates shift (CoordinatesShift shift) {
        return new Coordinates(x + shift.xShift, y + shift.yShift);
    }

    public boolean canShift (CoordinatesShift shift) {
        int newX  = x + shift.xShift;
        int newY  = y + shift.yShift;

        if((newX < 1) || (newX > 10)) return false;
        if((newY < 1) || (newY > 10)) return false;

        return true;
    }

}
