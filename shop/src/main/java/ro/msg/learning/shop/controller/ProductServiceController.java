package ro.msg.learning.shop.controller;

import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts().stream().map(productMapper::convertFromEntity).collect(Collectors.toList()), HttpStatus.OK);
    }
    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO>
        getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(productMapper.convertFromEntity(product), HttpStatus.OK);
        }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductDTO>
        updateProductById(@RequestBody ProductDTO productDTO, @PathVariable("id") int id) {
        Product product = productMapper.convertToEntity(productDTO);
        product = productService.updateProductById(product, id);
        return new ResponseEntity<>(productMapper.convertFromEntity(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        productService.addProduct(product);
        return new ResponseEntity<>(productMapper.convertFromEntity(product), HttpStatus.OK);
    }


}
