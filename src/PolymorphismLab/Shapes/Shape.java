package PolymorphismLab.Shapes;

abstract class Shape {
    private double perimeter;
    private double area;

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    abstract double calculatePerimeter();

    abstract double calculateArea();
}
