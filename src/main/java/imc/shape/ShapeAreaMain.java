package imc.shape;

import imc.model.Circle;
import imc.visitor.IShapeVisitor;
import imc.visitor.*;


public class ShapeAreaMain 
{
    public static void main( String[] args ) {
    	// visitor instance for ShapeArea instantiated
    	IShapeVisitor<Double> visitor = new ShapeArea();
    	// apply visitor interface to compute Shape circle area
    	Double area = visitor.apply(new Circle(1.00D)); 
		Double checkVal = new Double(Math.PI);
        System.out.println("Value of Area is " + area);
    }
}
