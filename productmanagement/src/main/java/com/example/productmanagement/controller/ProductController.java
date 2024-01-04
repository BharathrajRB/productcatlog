package com.example.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.example.productmanagement.modal.Product;
import com.example.productmanagement.service.ProductService;

import java.util.ArrayList;
import java.util.List;

// ProductController.java
@Controller
public class ProductController {
  @Autowired
  private ProductService productService;

  private List<Product> cart = new ArrayList<>();

  @GetMapping("/products")
  public String productList(Model model) {
    List<Product> products = productService.findAll();
    model.addAttribute("products", products);
    return "product-list";
  }

  @GetMapping("/addToCart/{productId}")
  public String addToCart(@PathVariable Long productId) {
    Product product = productService.findById(productId).orElse(null);
    if (product != null) {
      cart.add(product);
    }
    return "redirect:/products";
  }

  @GetMapping("/checkout")
  public String checkout(Model model) {
    double totalPrice = cart.stream().mapToDouble(Product::getPrice).sum();
    model.addAttribute("cart", cart);
    model.addAttribute("totalPrice", totalPrice);
    return "checkout";
  }
}
