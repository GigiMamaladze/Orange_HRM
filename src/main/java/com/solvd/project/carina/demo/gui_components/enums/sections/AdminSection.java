package com.solvd.project.carina.demo.gui_components.enums.sections;

public enum AdminSection {

    JOB("Job "),
    ORGANIZATION("Organization ");

    private final String section;

    AdminSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public enum AdminSubSection {

        JOB_JOB_TITLE("Job Titles"),
        ORGANIZATION_GENERAL_INFORMATION("General Information");

        private final String subsection;

        AdminSubSection(String subsection) {
            this.subsection = subsection;
        }

        public String getSubsection() {
            return subsection;
        }
    }
}
