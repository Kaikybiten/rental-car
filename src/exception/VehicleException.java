package exception;

import java.io.Serial;

public class VehicleException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public VehicleException(String message) {
        super(message);
    }
}
