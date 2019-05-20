package imc.model;
import imc.visitor.IShapeVisitor;

public interface IShape<R> {
	// Return the result of applying the given visitor to the applied Shape
	public R accept(IShapeVisitor<R> v);

}
