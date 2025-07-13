package Items;

public class DuplicateItemFoundException extends RuntimeException {
    public DuplicateItemFoundException(String message) {
        super(message);
    }
}
