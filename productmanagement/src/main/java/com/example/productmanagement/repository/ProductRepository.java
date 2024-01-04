package com.example.productmanagement.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productmanagement.modal.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

// @Query("select product from Product product where concat(product.id,' ',product.name,' ',product.price) like %?1%")
// public List<Product> search(String keyword);
// public Product findByproductName(String productName);


}
