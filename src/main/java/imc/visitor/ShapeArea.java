package imc.visitor;

import imc.exception.UnknownShapeException;
import imc.model.Circle;
import imc.model.IShape;
import imc.model.Rectangle;
import imc.model.Triangle;

//ShapeArea is a function object over IShapes that computes their area
public class ShapeArea implements IShapeVisitor<Double> {
	
	// IShapeVisitor interface implementation for different shapes
	public Double visit(Circle circle) {
		return 3.141592653589793D * Math.pow(circle.getRadius(), 2.0D);
	}

	public Double visit(Rectangle rectangle) {
		return rectangle.getWidth() * rectangle.getHeight();
	}

	public Double visit(Triangle triangle) {
		return (triangle.getBase() * triangle.getHeight()) / 2.0D;
				
	}

	// IShapeVisitor interface implementation for unknown shape by throw exception
	public Double visit(IShape<?> shape) {
		throw new UnknownShapeException(shape);

	}
	
	// Everything from the IFunc interface:
	 public Double apply(IShape<Double> s) { return s.accept(this); }

}
