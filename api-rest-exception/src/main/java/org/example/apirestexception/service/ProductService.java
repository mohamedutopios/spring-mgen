package org.example.apirestexception.service;

import org.example.apirestexception.exception.ProductNotFoundException;
import org.example.apirestexception.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();


    public ProductService() {
        productList.add(new Product(1, "PC", 999.99));
        productList.add(new Product(2, "Iphone", 1999.99));
        productList.add(new Product(3, "PS5 Pro", 599.99));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Optional<Product> getProductById(Integer id){
        return productList
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public Product updateProduct(Integer id, Product product) {
        Product existingProduct = getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        int index = productList.indexOf(existingProduct);
        productList.set(index, product);
        return existingProduct;

    }

    public void deleteProduct(Integer id) {
        Product product = getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productList.remove(product);
    }



}
