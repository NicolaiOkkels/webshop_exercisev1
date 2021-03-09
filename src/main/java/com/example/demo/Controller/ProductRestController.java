package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

/*
    //Contructor injection

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

 */

    @GetMapping("/products")
    public List<Product> product() {
        return productService.readAll();
    }

    @GetMapping("/products/{id}")
    public Product productByID(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductByID(@PathVariable("id") long id) {
        productService.delete(id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> productUpdate(@PathVariable("id") long id, @RequestBody Product productDetails) {
        Product product = productService.getProduct(id);

        product.setProductid(productDetails.getProductid());
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        final Product updatedProduct = productService.update(product);

        return ResponseEntity.ok(updatedProduct);
    }


    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = new Product(product.getProductid(), product.getName(), product.getPrice());
        productService.create(newProduct);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/products/" + product.getProductid());
        return new ResponseEntity<Product>(newProduct, headers, HttpStatus.CREATED);
    }
}