package com.solvd.project.carina.demo.components.enums.utils;

import com.solvd.project.carina.demo.components.exceptions.UnknownOsException;

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
        throw new UnknownOsException("Unknown OS name");
    }
}
