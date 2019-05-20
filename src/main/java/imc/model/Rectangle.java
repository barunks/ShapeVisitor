package imc.model;

import imc.visitor.IShapeVisitor;

/**
 * 
 * Rectangle class with width and height as constructor Parameter
 *
 */
public class Rectangle implements IShape<Double>{
	
	private final Double width;
	private final Double height;

	public Rectangle(Double width, Double height) {
		if (width <= 0D) {
			throw new IllegalArgumentException("Rectangle width : " + width + " cannot be less than or equal to zero");
		}
		if (height <= 0D) {
			throw new IllegalArgumentException("Rectangle height : " + height + " cannot be less than or equal to zero");
		}
		this.width = width;
		this.height = height;
	}

	public Double getWidth() {
		return this.width;
	}

	public Double getHeight() {
		return this.height;
	}
	
	// Return the result of applying the given visitor to Rectangle shape
	public Double accept(IShapeVisitor<Double> v) {return (Double) v.visit(this);}

}
