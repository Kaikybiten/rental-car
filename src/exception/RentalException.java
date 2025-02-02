package exception;

import java.io.Serial;

public class RentalException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RentalException(String message) {
      super(message);
    }
}
