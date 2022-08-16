package ro.msg.learning.shop.repository.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(int id) {
        super("Category" + id + "not found.");
    }
}
