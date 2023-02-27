package com.solvd.project.carina.demo.gui_components.utils.enums;

import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;

public enum Platform {

    WINDOWS,
    MAC,
    LINUX;

    public static Platform getByName(String name) throws UnknownOsException {
        for (Platform platform : values()) {
            if (platform.name().equalsIgnoreCase(name)) {
                return platform;
            }
        }
        throw new UnknownOsException("Unknown os name");
    }
}
