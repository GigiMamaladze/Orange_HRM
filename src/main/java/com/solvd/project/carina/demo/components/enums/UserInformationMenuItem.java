package com.solvd.project.carina.demo.components.enums;

public enum UserInformationMenuItem {

    PERSONA_DETAILS("Personal Details"),
    CONTACT_DETAILS("Contact Details"),
    EMERGENCY_CONTRACT("Emergency Contacts");

    private final String menuItem;

    UserInformationMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItem() {
        return menuItem;
    }
}
