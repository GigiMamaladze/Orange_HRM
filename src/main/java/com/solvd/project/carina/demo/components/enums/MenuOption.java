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

    MY_INFO("My Info"),

    DIRECTORY("Directory"),

    MAINTENANCE("Maintenance"),
    MAINTENANCE_PURGE_RECORDS("Purge Records "),
    MAINTENANCE_PURGE_RECORDS_CANDIDATE_RECORDS("Candidate Records"),
    MAINTENANCE_ACCESS_RECORDS("Access Records");

    private final String menuOption;

    MenuOption(String menuOption) {
        this.menuOption = menuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }
}
