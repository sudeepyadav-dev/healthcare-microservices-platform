package com.healthcare.authservice.dto;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;   // optional — usually for registration/login only

    // 🔸 Role field added
    private String role; // e.g. ROLE_DOCTOR, ROLE_PATIENT, ROLE_ADMIN

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

