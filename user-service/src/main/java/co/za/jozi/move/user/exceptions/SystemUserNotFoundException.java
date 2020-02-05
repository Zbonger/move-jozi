package co.za.jozi.move.user.exceptions;

public class SystemUserNotFoundException extends RuntimeException {
    public SystemUserNotFoundException(final String message) {
        super(message);
    }
}
