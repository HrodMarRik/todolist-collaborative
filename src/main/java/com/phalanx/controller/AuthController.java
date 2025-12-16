package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.Users;
import com.phalanx.service.JwtService;
import com.phalanx.service.UsersRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {
    
    @Autowired
    private UsersRepository usersRepository;
    
    @Autowired
    private JwtService jwtService;
    
    /**
     * Endpoint de connexion
     * POST /api/auth/login
     * Body: {"email": "user@example.com", "password": "password123"}
     */
    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        
        if (email == null || password == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Email et mot de passe requis");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        // Recherche de l'utilisateur par email
        Optional<Users> userOpt = usersRepository.findAll().stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst();
        
        if (userOpt.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Utilisateur non trouvé");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        
        Users user = userOpt.get();
        
        // Vérification du mot de passe (simple comparaison pour projet école)
        // En production, utiliser BCrypt ou autre hashage
        if (!password.equals(user.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Mot de passe incorrect");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        
        // Génération du token JWT
        String token = jwtService.generateToken(email);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Connexion réussie");
        response.put("token", token);
        response.put("user", Map.of(
            "id", user.getId_users(),
            "email", user.getEmail(),
            "firstName", user.getFirstname() != null ? user.getFirstname() : "",
            "lastName", user.getLastname() != null ? user.getLastname() : "",
            "role", user.getRole() != null ? user.getRole() : ""
        ));
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint d'inscription
     * POST /api/auth/register
     * Body: {"lastName": "Doe", "firstName": "John", "email": "john@test.com", "password": "password123", "role": "user", "avatar": ""}
     */
    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String lastName = body.get("lastName");
        String firstName = body.get("firstName");
        String role = body.get("role");
        String avatar = body.get("avatar");
        
        if (email == null || password == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Email et mot de passe requis");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        // Vérifier si l'utilisateur existe déjà
        boolean userExists = usersRepository.findAll().stream()
                .anyMatch(u -> email.equals(u.getEmail()));
        
        if (userExists) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Un utilisateur avec cet email existe déjà");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        
        // Créer le nouvel utilisateur
        Users newUser = new Users(
            lastName != null ? lastName : "",
            firstName != null ? firstName : "",
            email,
            password, // En production, hasher le mot de passe
            role != null ? role : "user",
            avatar != null ? avatar : "",
            null, null, null, null
        );
        
        Users savedUser = usersRepository.save(newUser);
        
        // Générer le token JWT
        String token = jwtService.generateToken(email);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Inscription réussie");
        response.put("token", token);
        response.put("user", Map.of(
            "id", savedUser.getId_users(),
            "email", savedUser.getEmail(),
            "firstName", savedUser.getFirstname() != null ? savedUser.getFirstname() : "",
            "lastName", savedUser.getLastname() != null ? savedUser.getLastname() : "",
            "role", savedUser.getRole() != null ? savedUser.getRole() : ""
        ));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
