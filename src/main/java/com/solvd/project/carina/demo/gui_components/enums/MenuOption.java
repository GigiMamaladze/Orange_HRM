package com.solvd.project.carina.demo.gui_components.enums;

public enum MenuOption {

    ADMIN("Admin"),
    ADMIN_JOB("Job "),
    ADMIN_JOB_TITLE("Job Titles"),
    ADMIN_ORGANIZATION("Organization "),
    ADMIN_ORGANIZATION_GENERAL_INFORMATION("General Information"),


    PIM("PIM"),
    PIM_ADD_EMPLOYEE("Add Employee");

    private final String menuOption;


    MenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }
}
