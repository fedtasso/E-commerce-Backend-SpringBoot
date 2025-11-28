package com.federicotasso.proyectofinal.service;

import com.federicotasso.proyectofinal.dto.user.UserCreateRequest;
import com.federicotasso.proyectofinal.dto.user.UserPasswordUpdateRequest;
import com.federicotasso.proyectofinal.dto.user.UserResponse;
import com.federicotasso.proyectofinal.dto.user.UserUpdateRequest;
import com.federicotasso.proyectofinal.mapper.UserMapper;
import com.federicotasso.proyectofinal.model.User;
import com.federicotasso.proyectofinal.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, UserMapper userMapper,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
  }

  public UserResponse createUser(UserCreateRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("El email ya se encuentra registrado");
    }
    User user = userMapper.toEntity(request);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    User savedUser = userRepository.save(user);
    return userMapper.toResponse(savedUser);
  }

  public List<UserResponse> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
  }

  public UserResponse getUserByEmail(String email) {
    User user = userRepository.findByEmail(email).orElseThrow(()
        -> new RuntimeException("El email %s no fue encontrado".formatted(email))
    );
    return userMapper.toResponse(user);
  }

  public UserResponse getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(()
        -> new RuntimeException("El id numero %s no fue encontrado".formatted(id))
    );
    return userMapper.toResponse(user);
  }

  public UserResponse updateUser(Long id, UserUpdateRequest request) {
    return userRepository.findById(id).map(dbUser -> {

      if (request.getEmail() != null && !request.getEmail().isBlank() &&
          !dbUser.getEmail().equals(request.getEmail()) &&
          userRepository.existsByEmail(request.getEmail())) {
        throw new RuntimeException("El email ya está en uso");
      }
      if (request.getName() != null && !request.getName().isBlank()) {
        dbUser.setName(request.getName());
      }
      if (request.getAvatar() != null) {
        dbUser.setAvatar(request.getAvatar());
      }
      if (request.getPhone() != null) {
        dbUser.setPhone(request.getPhone());
      }
      if (request.getEmail() != null && !request.getEmail().isBlank()) {
        dbUser.setEmail(request.getEmail());
      }
      User updateUser = userRepository.save(dbUser);
      return userMapper.toResponse(updateUser);
    }).orElseThrow(() -> new RuntimeException("El id numero %s no fue encontrado".formatted(id)));
  }

  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new RuntimeException("Usuario con id %s no encontrado".formatted(id));
    }
    userRepository.deleteById(id);
  }

  public void updatePassword(Long id, UserPasswordUpdateRequest request) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
      throw new RuntimeException("Contraseña actual incorrecta");
    }

    user.setPassword(passwordEncoder.encode(request.getNewPassword()));
    userRepository.save(user);
  }

}
