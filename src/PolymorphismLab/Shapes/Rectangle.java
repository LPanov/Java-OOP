package PolymorphismLab.Shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2*getHeight() + 2*getWidth();
    }

    @Override
    public double calculateArea() {
       return getHeight()*getWidth();
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
