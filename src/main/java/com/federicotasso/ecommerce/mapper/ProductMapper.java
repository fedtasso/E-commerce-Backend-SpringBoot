package com.federicotasso.ecommerce.mapper;

import com.federicotasso.ecommerce.dto.product.ProductCreateRequest;
import com.federicotasso.ecommerce.dto.product.ProductResponse;
import com.federicotasso.ecommerce.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  public Product toEntity(ProductCreateRequest request) {
    Product product = new Product();
    product.setTitle(request.getTitle());
    product.setPrice(request.getPrice());
    product.setDescription(request.getDescription());
    product.setCategory(request.getCategory());
    product.setImage(request.getImage());
    product.setStock(request.getStock());
    return product;
  }

  public ProductResponse toResponse(Product product) {
    ProductResponse response = new ProductResponse();
    response.setId(product.getId());
    response.setTitle(product.getTitle());
    response.setPrice(product.getPrice());
    response.setDescription(product.getDescription());
    response.setCategory(product.getCategory());
    response.setImage(product.getImage());
    response.setStock(product.getStock());
    response.setCreatedAt(product.getCreatedAt());
    return response;
  }
}
