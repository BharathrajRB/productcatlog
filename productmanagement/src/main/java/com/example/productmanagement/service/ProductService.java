
package com.example.productmanagement.service;

import java.util.*;
import com.example.productmanagement.modal.Product;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public void createProduct(Product product) {
    productRepository.save(product);
  }

  public void updateProduct(Long id, Product product) {
    Optional<Product> existingproduct = productRepository.findById(id);
    if (existingproduct.isPresent()) {
      Product updateProduct = existingproduct.get();
      updateProduct.setName(product.getName());
      updateProduct.setDescription(product.getDescription());
      updateProduct.setAvailableStock(10);
      updateProduct.setPrice(1000);
      productRepository.save(updateProduct);
    }
  }
}