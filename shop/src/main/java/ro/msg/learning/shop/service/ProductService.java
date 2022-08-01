package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Product;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //Get specific product
    public Product getProductById(@PathVariable int id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    //Post product
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    //Put product
    public Product updateProductById(@RequestBody Product newProduct, @PathVariable int id) {
        return productRepository.findById(id).map(product -> {
                    product.setName(newProduct.getName());
                    product.setProductCategory(newProduct.getProductCategory());
                    product.setSupplierId(newProduct.getSupplierId());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setWeight(newProduct.getWeight());
                    product.setImage_url(newProduct.getImage_url());
                    return productRepository.save(newProduct);
                })
                .orElseGet(() -> {
                    newProduct.setProductId(id);
                    return productRepository.save(newProduct);
                });
    }

    //Delete Product
    public void deleteProduct(@PathVariable int id) { productRepository.deleteById(id); }

}
