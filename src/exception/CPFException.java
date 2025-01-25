package exception;

import java.io.Serial;

public class CPFException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    
    public CPFException(String message) {
        super(message);
    }
}
