package exception;

import java.io.Serial;

public class CpfException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    
    public CpfException(String message) {
        super(message);
    }
}
