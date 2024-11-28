package org.example.tpapirest.service;


import org.example.tpapirest.exception.MaxPriceExceededException;
import org.example.tpapirest.model.Category;
import org.example.tpapirest.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Initial sample data

       // products.add(new Product(1, "Laptop", 999.99, Category.ELECTRONICS));
        // products.add(new Product(2, "Book", 19.99, Category.BOOKS));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null); // Retourne null si non trouvé
    }

    public Product addProduct(Product product) {
        validatePrice(product.getPrice());
        products.add(product);
        return product;
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = getProductById(id);
        if (existingProduct == null) {
            throw new IllegalArgumentException("Product with ID " + id + " does not exist");
        }
        validatePrice(updatedProduct.getPrice());
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        return existingProduct;
    }

    public void deleteProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            products.remove(product);
        }
    }

    private void validatePrice(Double price) {
        if (price > 1000) {
            throw new MaxPriceExceededException("Price cannot exceed 1000. Given price: " + price);
        }
    }
}
