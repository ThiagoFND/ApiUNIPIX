package br.com.api.authlogin.model;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    EMPRESA("empresa");
    
    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}