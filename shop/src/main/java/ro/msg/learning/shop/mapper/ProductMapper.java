package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO convertFromEntity(Product product) {
        return new ProductDTO(product.getProductId(), product.getProductCategory().getName(), product.getSupplierId().getId(), product.getName(),
                product.getDescription(), product.getPrice(), product.getWeight(), product.getImage_url());
    }

}
