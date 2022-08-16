package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.exception.ProductNotFoundException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, SupplierService supplierService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product addProduct(Product product) {
        categoryService.productCategory(product.getProductCategory());
        supplierService.supplier(product.getSupplierId());
        return productRepository.save(product);
    }

    public Product updateProductById(Product newProduct, int id) {
        return productRepository.findById(id).map(product -> {
                    product.setName(newProduct.getName());
                    product.setProductCategory(categoryService.replaceProductCategory(newProduct.getProductCategory(),id));
                    product.setSupplierId(supplierService.replaceSupplier(newProduct.getSupplierId(),id));
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    product.setWeight(newProduct.getWeight());
                    product.setImage_url(newProduct.getImage_url());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setProductId(id);
                    return productRepository.save(newProduct);
                });
    }

    public void deleteProduct( int id) { productRepository.deleteById(id); }

    public boolean existsById(int id) {
        return productRepository.existsById(id);
    }
}
