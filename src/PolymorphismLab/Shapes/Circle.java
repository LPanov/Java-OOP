package PolymorphismLab.Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*getRadius();
    }

    @Override
    public double calculateArea() {
        return Math.PI*getRadius()*getRadius();
    }

    public final double getRadius() {
        return radius;
    }
}
