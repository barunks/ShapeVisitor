package imc.model;

import imc.visitor.IShapeVisitor;

/**
 * 
 * Circle class with radius as constructor Parameter
 *
 */
public class Circle implements IShape<Double> {
	private final Double radius;
	
	public Circle(Double radius) {
		if (radius <= 0D) {
			throw new IllegalArgumentException("Circle radius : " + radius + " cannot be less than or equal to zero");
		}
		
		this.radius = radius;
	}

	public Double getRadius() {
		return this.radius;
	}
	
	// Return the result of applying the given visitor to Circle shape
	public Double accept(IShapeVisitor<Double> v) {return (Double) v.visit(this);}

}