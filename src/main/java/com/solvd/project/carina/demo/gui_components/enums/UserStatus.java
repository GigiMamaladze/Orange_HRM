package com.solvd.project.carina.demo.gui_components.enums;

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
