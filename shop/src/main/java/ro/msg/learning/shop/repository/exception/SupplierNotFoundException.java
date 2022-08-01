package ro.msg.learning.shop.repository.exception;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(int id) {
        super("Supplier" + id + "not found.");
    }
}
