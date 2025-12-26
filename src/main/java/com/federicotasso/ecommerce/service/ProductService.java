package com.federicotasso.ecommerce.service;

import com.federicotasso.ecommerce.dto.product.ProductCreateRequest;
import com.federicotasso.ecommerce.dto.product.ProductResponse;
import com.federicotasso.ecommerce.dto.product.ProductUpdateRequest;
import com.federicotasso.ecommerce.exception.business.ProductNotFoundException;
import com.federicotasso.ecommerce.mapper.ProductMapper;
import com.federicotasso.ecommerce.model.Product;
import com.federicotasso.ecommerce.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Transactional
  public ProductResponse createProduct(ProductCreateRequest request) {
    Product product = productMapper.toEntity(request);
    product.setCreatedAt(LocalDateTime.now());
    Product savedProduct = productRepository.save(product);
    return productMapper.toResponse(savedProduct);
  }

  @Transactional(readOnly = true)
  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().map(productMapper::toResponse).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public ProductResponse getProductById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));
    return productMapper.toResponse(product);
  }

  @Transactional
  public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
    return productRepository.findById(id).map(dbProduct -> {
      if (request.getTitle() != null && !request.getTitle().isBlank()) {
        dbProduct.setTitle(request.getTitle());
      }
      if (request.getPrice() != null) {
        dbProduct.setPrice(request.getPrice());
      }
      if (request.getDescription() != null) {
        dbProduct.setDescription(request.getDescription());
      }
      if (request.getCategory() != null && !request.getCategory().isBlank()) {
        dbProduct.setCategory(request.getCategory());
      }
      if (request.getImage() != null) {
        dbProduct.setImage(request.getImage());
      }
      if (request.getStock() != null) {
        dbProduct.setStock(request.getStock());
      }

      Product updateProduct = productRepository.save(dbProduct);
      return productMapper.toResponse(updateProduct);
    }).orElseThrow(() -> new ProductNotFoundException(id));
  }

  @Transactional
  public void deleteProduct(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productRepository.deleteById(id);
  }
}