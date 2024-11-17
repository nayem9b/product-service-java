package com.nayem.microservices.product.service;

import com.nayem.microservices.product.dto.ProductRequest;
import com.nayem.microservices.product.model.Product;
import com.nayem.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
       Product product = Product.builder()
               .name(productRequest.name())
               .description(productRequest.description())
               .price(productRequest.price())
               .build();
       productRepository.save(product);
    }

}
