package com.federicotasso.proyectofinal.service;

import com.federicotasso.proyectofinal.dto.ProductRequest;
import com.federicotasso.proyectofinal.dto.ProductResponse;
import com.federicotasso.proyectofinal.mapper.ProductMapper;
import com.federicotasso.proyectofinal.model.Product;
import com.federicotasso.proyectofinal.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  public ProductResponse createProduct(ProductRequest request) {
    Product product = productMapper.toEntity(request);
    product.setCreatedAt(LocalDateTime.now());
    Product savedProduct = productRepository.save(product);
    return productMapper.toResponse(savedProduct);
  }

  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream().map(productMapper::toResponse).collect(Collectors.toList());
  }

  public ProductResponse getProductById(Long id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    return productMapper.toResponse(product);
  }

  public ProductResponse updateProduct(Long id, ProductRequest request) {
    return productRepository.findById(id).map(dbproduct -> {
      dbproduct.setTitle(request.getTitle());
      dbproduct.setPrice(request.getPrice());
      dbproduct.setDescription(request.getDescription());
      dbproduct.setCategory(request.getCategory());
      dbproduct.setImage(request.getImage());
      dbproduct.setStock(request.getStock());

      Product updateProduct = productRepository.save(dbproduct);
      return productMapper.toResponse(updateProduct);
    }).orElseThrow(() -> new RuntimeException("Producto con id %s no encontrado".formatted(id)));
  }

  public void deleteProduct(Long id) {
    if (!productRepository.existsById(id)) {
      throw new RuntimeException("Producto con id %s no encontrado".formatted(id));
    }
    productRepository.deleteById(id);
  }
}