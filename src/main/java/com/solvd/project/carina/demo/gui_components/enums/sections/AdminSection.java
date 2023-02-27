package com.solvd.project.carina.demo.gui_components.enums.sections;

public enum AdminSection {

    JOB("Job "),
    JOB_TITLE("Job Titles"),

    ORGANIZATION("Organization "),
    ORGANIZATION_GENERAL_INFORMATION("General Information");


    private final String section;

    AdminSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }
}
