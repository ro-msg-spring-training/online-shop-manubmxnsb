package ro.msg.learning.shop.service;

import ro.msg.learning.shop.repository.exception.SupplierNotFoundException;
import ro.msg.learning.shop.model.Supplier;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.SupplierRepository;

import java.util.List;

public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/suppliers")
    List<Supplier> all() {
        return supplierRepository.findAll();
    }

    @GetMapping("/suppliers/{id}")
    Supplier one(@PathVariable int id) {
        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));
    }

    @PostMapping("/suppliers")
    Supplier supplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @PutMapping("/suppliers")
    Supplier replaceSupplier(@RequestBody Supplier newSupplier, @PathVariable int id) {
        return supplierRepository.findById(id).map(supplier -> {
                    supplier.setName(newSupplier.getName());
                    return supplierRepository.save(newSupplier);
                })
                .orElseGet(() -> {
                    newSupplier.setId(id);
                    return supplierRepository.save(newSupplier);
                });
    }

    @DeleteMapping("suppliers/{id}")
    void deleteSupplier(@PathVariable int id) { supplierRepository.deleteById(id); }

}
