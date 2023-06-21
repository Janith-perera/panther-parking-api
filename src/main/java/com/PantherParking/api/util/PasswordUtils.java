package com.PantherParking.api.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
  
  // Hashes a password using BCryptPasswordEncoder
  public static String hashPassword(String password) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return passwordEncoder.encode(password);
  }
  
  // Checks if a given password matches a hashed password
  public static boolean isPasswordMatch(String password, String hashedPassword) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return passwordEncoder.matches(password, hashedPassword);
  }
  
}

