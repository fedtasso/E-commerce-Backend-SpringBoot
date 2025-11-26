package com.federicotasso.proyectofinal.controller;

import com.federicotasso.proyectofinal.dto.ProductRequest;
import com.federicotasso.proyectofinal.dto.ProductResponse;
import com.federicotasso.proyectofinal.mapper.ProductMapper;
import com.federicotasso.proyectofinal.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;
  private final ProductMapper productMapper;

  public ProductController(ProductService productService, ProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }

  @PostMapping
  public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
    return productService.createProduct(request);
  }

  @GetMapping
  public List<ProductResponse> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public ProductResponse getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PutMapping("/{id}")
  public ProductResponse updateProduct(@PathVariable Long id,
      @Valid @RequestBody ProductRequest request) {
    return productService.updateProduct(id, request);
  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }
}
