package WorkingWithAbstractionLab.pointInRectangle;

import java.util.function.Predicate;

public class Rectangle {
    private Point bLeft;
    private Point tRight;

    public Rectangle(Point bLeft, Point tRight) {
        this.bLeft = bLeft;
        this.tRight = tRight;
    }

    public boolean contains(int x, int y) {
        return x >= bLeft.getX() && x <= tRight.getX() &&
                y >= bLeft.getY() && y <= tRight.getY();
    }
}
