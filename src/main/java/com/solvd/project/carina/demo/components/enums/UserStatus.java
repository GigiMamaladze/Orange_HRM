package com.solvd.project.carina.demo.components.enums;

public enum UserStatus {

    ENABLED("Enabled"),
    DISABLED("Disabled");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
