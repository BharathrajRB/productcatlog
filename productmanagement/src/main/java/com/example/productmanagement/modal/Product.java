package com.example.productmanagement.modal;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String description;
  private BigDecimal price;
  private int availableStock;
  @ManyToOne
  @JoinColumn(name = "id")
  private Category Category_id;
  

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal i) {
    this.price = i;
  }

  public int getAvailableStock() {
    return availableStock;
  }

  public void setAvailableStock(int availableStock) {
    this.availableStock = availableStock;
  }

  public Category getCategory_id() {
    return Category_id;
  }

  public void setCategory_id(Category category_id) {
    Category_id = category_id;
  }

}