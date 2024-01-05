package com.example.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.modal.Product;
import com.example.productmanagement.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  public List<Product> listAll() {
    return productRepository.findAll();
  }

  public void save(Product product) {
    productRepository.save(product);
  }
  public Product getById(Long id) {
    return productRepository.findById(id).get();

  }
  public void delete(Long id) {
    productRepository.deleteById(id);
      
   
  }
}
