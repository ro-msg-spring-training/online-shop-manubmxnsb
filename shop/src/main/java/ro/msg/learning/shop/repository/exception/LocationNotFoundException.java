package ro.msg.learning.shop.repository.exception;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(int id) {
        super("Location" + id + "not found.");
    }
}

