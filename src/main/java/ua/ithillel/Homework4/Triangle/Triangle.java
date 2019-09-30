package Homework4.Triangle;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private String typeOfTriangle;

    public Triangle(Point a, Point b, Point c, String typeOfTriangle) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.typeOfTriangle = typeOfTriangle;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public String getTypeOfTriangle() {
        return typeOfTriangle;
    }

    public void setTypeOfTriangle(String typeOfTriangle) {
        this.typeOfTriangle = typeOfTriangle;
    }

    @Override
    public String toString() {
        return "Triangle (" +
                "A = " + a +
                ", B = " + b +
                ", C = " + c +
                ", Type of triangle = " + typeOfTriangle +
                ')' + '\n';
    }
}

