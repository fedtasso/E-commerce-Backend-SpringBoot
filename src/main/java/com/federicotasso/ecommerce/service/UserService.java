package com.federicotasso.ecommerce.service;

import com.federicotasso.ecommerce.dto.user.UserCreateRequest;
import com.federicotasso.ecommerce.dto.user.UserPasswordUpdateRequest;
import com.federicotasso.ecommerce.dto.user.UserResponse;
import com.federicotasso.ecommerce.dto.user.UserUpdateRequest;
import com.federicotasso.ecommerce.exception.business.EmailAlreadyExistsException;
import com.federicotasso.ecommerce.exception.business.InvalidCredentialsException;
import com.federicotasso.ecommerce.exception.business.SamePasswordException;
import com.federicotasso.ecommerce.exception.business.UserNotFoundException;
import com.federicotasso.ecommerce.mapper.UserMapper;
import com.federicotasso.ecommerce.model.User;
import com.federicotasso.ecommerce.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public UserResponse createUser(UserCreateRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new EmailAlreadyExistsException(request.getEmail());
    }
    User user = userMapper.toEntity(request);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    User savedUser = userRepository.save(user);
    return userMapper.toResponse(savedUser);
  }

  @Transactional(readOnly = true)
  public List<UserResponse> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public UserResponse getUserByEmail(String email) {
    User user = userRepository.findByEmail(email).orElseThrow(()
        -> new UserNotFoundException(email)
    );
    return userMapper.toResponse(user);
  }

  @Transactional(readOnly = true)
  public UserResponse getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(()
        -> new UserNotFoundException(id)
    );
    return userMapper.toResponse(user);
  }

  @Transactional
  public UserResponse updateUser(Long id, UserUpdateRequest request) {

    User dbUser = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));

      if (request.getEmail() != null && !request.getEmail().isBlank() &&
          !dbUser.getEmail().equals(request.getEmail()) &&
          userRepository.existsByEmail(request.getEmail())) {
        throw new EmailAlreadyExistsException(request.getEmail());
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
    }

  @Transactional
  public void deleteUser(Long id) {
    userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    userRepository.deleteById(id);
  }

  @Transactional
  public void updatePassword(Long id, UserPasswordUpdateRequest request) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));

    if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
      throw new InvalidCredentialsException();
    }

    if (passwordEncoder.matches(request.getNewPassword(), user.getPassword())) {
      throw new SamePasswordException();
    }

    user.setPassword(passwordEncoder.encode(request.getNewPassword()));
    userRepository.save(user);
  }

  @Transactional(readOnly = true)
  public UserResponse login(String email, String password) {
    User user = userRepository.findByEmail(email)
        .filter(u -> passwordEncoder.matches(password, u.getPassword()))
        .orElseThrow(InvalidCredentialsException::new);

    return userMapper.toResponse(user);
  }
}
