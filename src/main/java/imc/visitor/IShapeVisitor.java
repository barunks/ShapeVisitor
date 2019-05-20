package imc.visitor;
import imc.model.Circle;
import imc.model.Rectangle;
import imc.model.IShape;
import imc.model.Triangle;

//An IShapeVisitor is a function over IShapes
public interface IShapeVisitor<R> extends IFunc<R, IShape<R>> {
	
	R visit(Circle circle);
	R visit(Triangle triangle);
	R visit(Rectangle rectangle);
	R visit(IShape<?> general);
}
