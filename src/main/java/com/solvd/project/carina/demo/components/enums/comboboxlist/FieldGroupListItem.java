package com.solvd.project.carina.demo.components.enums.comboboxlist;

public enum FieldGroupListItem {

    REPORTS_FIELD_GROUP_PERSONAL("Personal");

    private final String listItem;

    FieldGroupListItem(String listItem) {
        this.listItem = listItem;
    }

    public String getListItem() {
        return listItem;
    }
}
