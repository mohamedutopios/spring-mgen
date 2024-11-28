package org.example.apirestexception.controller;

import jakarta.validation.Valid;
import org.example.apirestexception.exception.ProductNotFoundException;
import org.example.apirestexception.model.Product;
import org.example.apirestexception.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProductList();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService
                .getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + " : " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(201).body(productService.addProduct(product));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + " : " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(200).body(productService.updateProduct(id,product));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }


}
