package com.solvd.project.carina.demo.components.enums;

public enum MenuOption {

    ADMIN("Admin"),
    ADMIN_JOB("Job "),
    ADMIN_JOB_TITLE("Job Titles"),
    ADMIN_ORGANIZATION("Organization "),
    ADMIN_ORGANIZATION_GENERAL_INFORMATION("General Information"),

    PIM("PIM"),
    PIM_ADD_EMPLOYEE("Add Employee"),
    PIM_REPORTS("Reports"),

    RECRUITMENT("Recruitment"),
    RECRUITMENT_VACANCIES("Vacancies"),

    MY_INFO("My Info");

    private final String menuOption;

    MenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }
}
