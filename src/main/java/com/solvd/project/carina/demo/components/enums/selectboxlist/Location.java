package com.solvd.project.carina.demo.components.enums.selectboxlist;

public enum Location {

    CANADIAN_REGIONAL_HQ("Canadian Regional HQ"),
    HQ_CA_USA("HQ - CA, USA"),
    NEW_YORK_SALES_OFFICE("New York Sales Office"),
    TEXAS("Texas R&D");

    private final String location;

    Location(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
