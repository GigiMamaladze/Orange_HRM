package com.solvd.project.carina.demo.gui_components.enums.sections;

public enum PimSection {

    EMPLOYEE_LIST("Employee List"),
    ADD_EMPLOYEE("Add Employee");

    private final String section;

    PimSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }
}
