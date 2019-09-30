package Homework4.Triangle;

import java.util.*;

public class TriangleProcessor {
    private TriangleProcessor() {

    }

    public static double getPerimeter(Triangle triangle) {
        double ab = Math.sqrt(Math.pow(triangle.getA().getX(), 2) + Math.pow(triangle.getA().getY(), 2) +
                Math.pow(triangle.getB().getX(), 2) + Math.pow(triangle.getB().getY(), 2));
        double bc = Math.sqrt(Math.pow(triangle.getB().getX(), 2) + Math.pow(triangle.getB().getY(), 2) +
                Math.pow(triangle.getC().getX(), 2) + Math.pow(triangle.getC().getY(), 2));
        double ca = Math.sqrt(Math.pow(triangle.getC().getX(), 2) + Math.pow(triangle.getC().getY(), 2) +
                Math.pow(triangle.getA().getX(), 2) + Math.pow(triangle.getA().getY(), 2));
        double perimeter = ab + bc + ca;

        return perimeter;
    }

    public static double getArea(Triangle triangle) {
        double halfPerimeter = getPerimeter(triangle) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - Math.sqrt(Math.pow(triangle.getB().getX(), 2) +
                Math.pow(triangle.getB().getY(), 2) + Math.pow(triangle.getC().getX(), 2) + Math.pow(triangle.getC().getY(), 2)))
                * (halfPerimeter - Math.sqrt(Math.pow(triangle.getC().getX(), 2) + Math.pow(triangle.getC().getY(), 2) +
                Math.pow(triangle.getA().getX(), 2) + Math.pow(triangle.getA().getY(), 2))) *
                (halfPerimeter - Math.sqrt(Math.pow(triangle.getA().getX(), 2) + Math.pow(triangle.getA().getY(), 2) +
                        Math.pow(triangle.getB().getX(), 2) + Math.pow(triangle.getB().getY(), 2))));
        return area;
    }

    public static String findAmountOfTriangles(Triangle[] triangles) {
        int isosceles = 0;
        int arbitrary = 0;
        int equilateral = 0;
        int rightangled = 0;

        for (Triangle triangle : triangles) {
            if (Objects.equals(triangle.getTypeOfTriangle(), "isosceles")) {
                isosceles++;
            }
            if (Objects.equals(triangle.getTypeOfTriangle(), "arbitrary")) {
                arbitrary++;
            }
            if (Objects.equals(triangle.getTypeOfTriangle(), "equilateral")) {
                equilateral++;
            }
            if (Objects.equals(triangle.getTypeOfTriangle(), "rightangled")) {
                rightangled++;
            }
        }
        return "Isosceles triangles = " + isosceles + ", arbitrary triangles = " + arbitrary + ", equilateral triangles = "
                + equilateral + ", rightangled triangles = " + rightangled;
    }

    public static Triangle[] findByType(Triangle[] triangles, String typeOfTriangle) {
        Triangle[] result = new Triangle[10];
        for (Triangle triangle : triangles) {
            if (Objects.equals(triangle.getTypeOfTriangle(), typeOfTriangle)) {
                result[0]=(triangle);
            }
        }
        return result;
    }



    public static String findMaxAndMinPerimeter(Triangle[] findByType) {
        Triangle[] result = new Triangle[12];

        double maxPer = 0;
        double minPer = 999999999;

        for (Triangle triangle : findByType) {
            double perimeter = getPerimeter(triangle);
            if (perimeter > maxPer) {
                maxPer = perimeter;
                result[0]=(triangle);
                //result.set(0, triangle);

                if (perimeter < minPer) {
                    minPer = perimeter;
                    result[1]=(triangle);
                    //result.set(1, triangle);
                }
            }
        }
        return "Triangle with MAX perimeter - " + result[0].toString() + ", triangle with MIN perimeter - " + result[1].toString();
    }
}
