package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String productCategoryName;
    private Integer supplierId;
    private String name;
    private String description;
    private Float price;
    private Double weight;
    private String image_url;

}
