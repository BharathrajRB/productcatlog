// package com.example.productmanagement.service;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.data.domain.*;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.productmanagement.modal.Product;
// import com.example.productmanagement.repository.ProductRepository;

// @Service
// public class ProductServiceImpl implements ProductService {

//     @Autowired
//     private ProductRepository productRepository;

//     @Override
//     public List<Product> getAllProduct(String keyword) {
//         if (keyword != null) {
//             return productRepository.search(keyword);
//         } else {
//             return (List<Product>) productRepository.findAll();
//         }
//     }

//     public Product saveProduct(Product product) {
//         return this.productRepository.save(product);
//     }

//     @Override
//     public Product getProductById(Long id){
//         Optional<Product> optional=productRepository.findById(Long id);
//         Product product=null;
//         if (optional.isPresent()) {
//             product=optional.get();
//         }
//         else{
//             throw new RuntimeException("Product not found"+id);
//         }
//         return product;
        
//     }

//     public void deleteProductById(Long id) {
//         this.productRepository.deleteById(id);
//     }

//     public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//         Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
//                 : Sort.by(sortField).descending();
//         Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//         return this.productRepository.findAll(pageable);

//     }
// }
