package com.solvd.project.carina.demo.components.enums;

public enum PersonalReportColumnTitle {

    EMPLOYEE_ID("Employee Id"),
    EMPLOYEE_LAST_NAME("Employee Last Name"),
    EMPLOYEE_FIRST_NAME("Employee First Name"),
    EMPLOYEE_MIDDLE_NAME("Employee Middle Name"),
    DATE_OF_BIRTH("Date of Birth"),
    NATIONALITY("Nationality"),
    GENDER("Gender"),
    MARITAL_STATUS("Marital Status"),
    DRIVERS_LICENSE_NUMBER("Driver's License Number"),
    LICENSE_EXPIRY_DATE("License Expiry Date"),
    OTHER_ID("Other Id");

    private final String columnTitle;

    PersonalReportColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getColumnTitle() {
        return columnTitle;
    }
}
