package Homework4.Triangle;

import java.util.*;

public class TriangleTest {
    public static void main (String [] args){

        Triangle[] triangles = createTriangles();


        Triangle[] isoscelesTriangles = TriangleProcessor.findByType(triangles, "isosceles");
        System.out.println(Arrays.toString(isoscelesTriangles));

        Triangle[] arbitraryTriangles = TriangleProcessor.findByType(triangles, "arbitrary");
        System.out.println(Arrays.toString(arbitraryTriangles));

        Triangle[] equilateralTriangles = TriangleProcessor.findByType(triangles, "equilateral");
        System.out.println(Arrays.toString(equilateralTriangles));

        Triangle[] rightangledTriangles = TriangleProcessor.findByType(triangles, "rightangled");
        System.out.println(Arrays.toString(rightangledTriangles));

        System.out.println(TriangleProcessor.findAmountOfTriangles(triangles));

        System.out.println(TriangleProcessor.findAmountOfTriangles(triangles));

        String maxAndMinObjectsFromIsosceles = TriangleProcessor.findMaxAndMinPerimeter(isoscelesTriangles);
        System.out.println(maxAndMinObjectsFromIsosceles);

        String maxAndMinObjectsFromArbitrary = TriangleProcessor.findMaxAndMinPerimeter(arbitraryTriangles);
        System.out.println(maxAndMinObjectsFromArbitrary);

        String maxAndMinObjectsFromEquilateral = TriangleProcessor.findMaxAndMinPerimeter(equilateralTriangles);
        System.out.println(maxAndMinObjectsFromEquilateral);

        String maxAndMinObjectsFromRightangled = TriangleProcessor.findMaxAndMinPerimeter(rightangledTriangles);
        System.out.println(maxAndMinObjectsFromRightangled);
    }

    public static Triangle[] createTriangles(){
        Triangle[] triangles = new Triangle[12];

        triangles[0]=(new Triangle(new Point(1.7, 3.2), new Point(4.0, 4.6), new Point(6.0, 7.5), "isosceles"));
        triangles[1]=(new Triangle(new Point(-2, -4), new Point(1,2), new Point(0, -3), "arbitrary"));
        triangles[2]=(new Triangle(new Point(2.2, 4), new Point(-3.0, -4), new Point(1, 3), "equilateral"));

        triangles[3]=(new Triangle(new Point(1.7, 2.8), new Point(3.4, 2.7), new Point(5.6, 5.8), "arbitrary"));
        triangles[4]=(new Triangle(new Point(1, -5), new Point(-2,1.9), new Point(4.5, -3), "arbitrary"));
        triangles[5]=(new Triangle(new Point(3.4, 2.6), new Point(-2, -5), new Point(2.5, 5), "equilateral"));

        triangles[6]=(new Triangle(new Point(3.1, 4.6), new Point(3.0, 3.1), new Point(5.0, 6.0), "isosceles"));
        triangles[7]=(new Triangle(new Point(-2.5, -1.4), new Point(7,-4), new Point(2.7, -4), "arbitrary"));
        triangles[8]=(new Triangle(new Point(4.3, 6), new Point(-5.1, 5), new Point(5.5, 3.4), "isosceles"));

        triangles[9]=(new Triangle(new Point(2, 4.8), new Point(3, 1.7), new Point(4.0, 2.0), "rightangled"));
        triangles[10]=(new Triangle(new Point(-4, -4), new Point(3,-1), new Point(5, 5.6), "rightangled"));
        triangles[11]=(new Triangle(new Point(5, 5.2), new Point(3.1, 4), new Point(2.6, 4.5), "isosceles"));

        //return triangles;
        return triangles;
    }


}

