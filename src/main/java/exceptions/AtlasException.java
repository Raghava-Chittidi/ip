package exceptions;

public class AtlasException extends Exception {
    public AtlasException(String message) {
        super("OOPS!!! " + message);
    }
}