package com.kalai.productservice.servie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kalai.productservice.dto.ProductRequest;
import com.kalai.productservice.dto.ProductResponse;
import com.kalai.productservice.model.Product;
import com.kalai.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServie {
   private  ProductRepository productRepository;

   public void createProduct(ProductRequest productRequest) {
      log.info("Creating Product");

      Product product = Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price())
            .build();

      productRepository.save(product);
      log.info("Product {} is created", product.getId());      
   }

   public List<ProductResponse> getAllProducts(){
      List<Product> products = productRepository.findAll();

      return products.stream().map(this::mapTopProductResponse).toList();
   }

   private ProductResponse mapTopProductResponse(Product product){
      return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
   }
}
