package monthandmathservice.exceptions;

public class ArithmeticException extends RuntimeException {
    private static final long serialVersionUID = 2256477558314496007L;

    public ArithmeticException() {
        super();
    }

    public ArithmeticException(String s) {
        super(s);
    }
}
