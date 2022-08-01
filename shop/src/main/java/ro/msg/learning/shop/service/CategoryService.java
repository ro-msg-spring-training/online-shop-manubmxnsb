package ro.msg.learning.shop.service;

import ro.msg.learning.shop.repository.exception.CategoryNotFoundException;
import ro.msg.learning.shop.model.ProductCategory;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.ProductCategoryRepository;

import java.util.List;

public class CategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public CategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @GetMapping("/productCategory")
    List<ProductCategory> all() {
        return productCategoryRepository.findAll();
    }

    @GetMapping("/productCategory/{id}")
    ProductCategory one(@PathVariable int id) {
        return productCategoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PostMapping("/productCategory")
    ProductCategory productCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    //In case of misspelling/restructuring, I let the user change categories as he wishes
    @PutMapping("/productCategory")
    ProductCategory replaceProductCategory(@RequestBody ProductCategory newProductCategory, @PathVariable int id) {
        return productCategoryRepository.findById(id).map(productCategory -> {
                    productCategory.setName(newProductCategory.getName());
                    productCategory.setDescription(newProductCategory.getDescription());
                    return productCategoryRepository.save(newProductCategory);
                })
                .orElseGet(() -> {
                    newProductCategory.setId(id);
                    return productCategoryRepository.save(newProductCategory);
                });
    }

    @DeleteMapping("products/{id}")
    void deleteProduct(@PathVariable int id) { productCategoryRepository.deleteById(id); }

}
