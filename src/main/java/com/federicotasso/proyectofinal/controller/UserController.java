package com.federicotasso.proyectofinal.controller;

import com.federicotasso.proyectofinal.dto.UserCreateRequest;
import com.federicotasso.proyectofinal.dto.UserPasswordUpdateRequest;
import com.federicotasso.proyectofinal.dto.UserResponse;
import com.federicotasso.proyectofinal.dto.UserUpdateRequest;
import com.federicotasso.proyectofinal.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public UserResponse createUser(@Valid @RequestBody UserCreateRequest request) {
    return userService.createUser(request);
  }

  @GetMapping
  public List<UserResponse> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public UserResponse getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/search")
  public UserResponse getUserByEmail(@RequestParam String email) {
    return userService.getUserByEmail(email);
  }

  @PutMapping("/{id}")
  public UserResponse updateUser(@PathVariable Long id,
      @Valid @RequestBody UserUpdateRequest request) {
    return userService.updateUser(id, request);
  }

  @PatchMapping("/{id}/password")
  public ResponseEntity<Void> updatePassword(@PathVariable Long id,
      @Valid @RequestBody UserPasswordUpdateRequest request) {
    userService.updatePassword(id, request);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}