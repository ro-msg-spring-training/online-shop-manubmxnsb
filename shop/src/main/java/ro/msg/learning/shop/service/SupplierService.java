package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.exception.SupplierNotFoundException;
import ro.msg.learning.shop.model.Supplier;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    List<Supplier> all() {
        return supplierRepository.findAll();
    }

    Supplier one(@PathVariable int id) {
        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));
    }

    Supplier supplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

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

    void deleteSupplier(@PathVariable int id) { supplierRepository.deleteById(id); }

}
