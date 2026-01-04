package com.kalai.productservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kalai.productservice.dto.ProductRequest;
import com.kalai.productservice.dto.ProductResponse;
import com.kalai.productservice.servie.ProductServie;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/products")
public class ProductController {

    ProductServie productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postMethodName(@RequestBody ProductRequest productRequest) {
        
         productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getMethodName(@RequestParam String param) {
        return productService.getAllProducts();
    }
    
    


}
