package ro.msg.learning.shop.controller;

import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductServiceController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getProducts().stream().map(productMapper::convertFromEntity).collect(Collectors.toList()), HttpStatus.OK);
    }
/*    @RequestMapping(value = "/products/{id}")
    public ResponseEntity<Object>
        getProductById(@RequestBody Product product, @PathVariable("id") int id) {
        productService.getProductById(id);
        return new ResponseEntity<>("Product was retrieved succesfully", HttpStatus.OK);
        }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
        updateProductById(@RequestBody Product product, @PathVariable("id") int id) {
        productService.updateProductById(product, id);
        return new ResponseEntity<>("Product was updated succesfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product was deleted succesfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product was added succesfully", HttpStatus.OK);
    }*/


}
