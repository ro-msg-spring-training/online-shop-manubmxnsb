package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Supplier;

@Component
public class ProductMapper {
    public ProductDTO convertFromEntity(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getProductCategory().getName(),
                product.getSupplierId().getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getImage_url());
    }

    public Product convertToEntity(ProductDTO productDto){
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .weight(productDto.getWeight())
                .supplierId(Supplier.builder().id(productDto.getSupplierId()).build())
                .productCategory(ProductCategory.builder().name(productDto.getProductCategoryName()).build())
                .image_url(productDto.getImage_url())
                .build();
    }

}
