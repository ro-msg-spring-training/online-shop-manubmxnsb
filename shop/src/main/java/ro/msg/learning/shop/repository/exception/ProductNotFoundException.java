package ro.msg.learning.shop.repository.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Product " + id + " not found.");
    }
}
