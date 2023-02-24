package com.solvd.project.carina.demo.gui_components.enums;

public enum UserRole {

    ADMIN("Admin"),
    ESS("ESS");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
