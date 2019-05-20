package imc.shape;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Before;

import imc.exception.UnknownShapeException;
import imc.model.Circle;
import imc.model.IShape;
import imc.model.Rectangle;
import imc.model.Triangle;
import imc.visitor.IShapeVisitor;
import imc.visitor.ShapeArea;

/**
 * Unit test for ShapeArea.
 */
public class TestShapeArea 
{
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
    
    private IShapeVisitor<Double> visitor;
    
    private class AbstractShape implements IShape<Double> {
    	public Double accept(IShapeVisitor<Double> v) {return (Double) v.visit(this);}
	}
	
	@Before
    public void init() {
		visitor = new ShapeArea();
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
    @Test
	public void testAreaOfCircle() {
		Double area = visitor.apply(new Circle(1.00D));
		Double checkVal = new Double(Math.PI);
		Assert.assertEquals(checkVal, area);
	}
	
    @Test
    public void testAreaOfRectangle() {
		Double area = visitor.apply(new Rectangle(4.00D, 6.00D));
		Double checkVal = new Double(24.00D);
		Assert.assertEquals(checkVal, area);
	}
	
    @Test
	public void testAreaOfTriangle() {
		Double area = visitor.apply(new Triangle(10.00D, 7.00D));
		Double checkVal = new Double(35.00D);
		Assert.assertEquals(checkVal, area);
	}
    
    @Test
	public void testExceptionWhenCircleRadiusIsNegative() {
    	Double radius = new Double(-1.00);
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Circle radius : " + radius + " cannot be less than or equal to zero");
		visitor.apply(new Circle(radius));
	}
    
    @Test
	public void testExceptionWhenRectangleWidthIsNegative() {
    	Double width = new Double(-10.00);
    	Double height = new Double(20.00);
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Rectangle width : " + width + " cannot be less than or equal to zero");
		visitor.apply(new Rectangle(width, height));
	}
    
    @Test
	public void testExceptionWhenRectangleHeightIsNegative() {
    	Double width = new Double(10.00);
    	Double height = new Double(-20.00);
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Rectangle height : " + height + " cannot be less than or equal to zero");
		visitor.apply(new Rectangle(width, height));
	}
    
    @Test
	public void testExceptionWhenTriangleBaseIsNegative() {
    	Double base = new Double(-10.00);
    	Double height = new Double(20.00);
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Triangle base : " + base + " cannot be less than or equal to zero");
		visitor.apply(new Triangle(base, height));
	}
    
    @Test
	public void testExceptionWhenTriangleHeightIsNegative() {
    	Double base = new Double(10.00);
    	Double height = new Double(-20.00);
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Triangle height : " + height + " cannot be less than or equal to zero");
		visitor.apply(new Triangle(base, height));
	}
    
    @Test
   	public void testExceptionWhenShapeClassIsUnknown() {
    	AbstractShape aShape = new AbstractShape();
       	exception.expect(UnknownShapeException.class);
       	exception.expectMessage("Shape with name: " + aShape.getClass().getCanonicalName() + " is undefined!!");
   		visitor.apply(aShape);
   	}

}
