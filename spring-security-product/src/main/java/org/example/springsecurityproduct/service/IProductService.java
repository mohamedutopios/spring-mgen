package org.example.springsecurityproduct.service;

import org.example.springsecurityproduct.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProducts();

    public Optional<Product> getProductById(Long id);

    public Product updateProduct(Product product);

    public void deleteProduct(Long id);
}
