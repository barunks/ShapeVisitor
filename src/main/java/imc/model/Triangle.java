package imc.model;

import imc.visitor.IShapeVisitor;

/**
 * 
 * Triangle class with base and height as constructor Parameter
 *
 */
public class Triangle implements IShape<Double> {
	private final Double base;
	private final Double height;

	public Triangle(Double base, Double height) {
		if (base <= 0D) {
			throw new IllegalArgumentException("Triangle base : " + base + " cannot be less than or equal to zero");
		}
		
		if (height <= 0D) {
			throw new IllegalArgumentException("Triangle height : " + height + " cannot be less than or equal to zero");
		}
		
		this.base = base;
		this.height = height;
	}

	public Double getBase() {
		return this.base;
	}

	public Double getHeight() {
		return this.height;
	}
	
	// Return the result of applying the given visitor to Triangle shape
	public Double accept(IShapeVisitor<Double> v) {return (Double) v.visit(this);}

}
