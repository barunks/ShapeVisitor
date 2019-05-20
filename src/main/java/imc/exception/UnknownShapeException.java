package imc.exception;

import imc.model.IShape;

/*
 * Create UnknownShapeException class as Runtime exception
 * for undefined shape to be tracked at the runtime
 */
public class UnknownShapeException extends RuntimeException {
	
		private static final long serialVersionUID = 1L;

		protected UnknownShapeException(String message) {
			super(message);
		}

		public UnknownShapeException(IShape<?> shape) {
			this("Shape with name: " + shape.getClass().getCanonicalName() + " is undefined!!");
		}
}
