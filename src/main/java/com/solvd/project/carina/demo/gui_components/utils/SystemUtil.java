package com.solvd.project.carina.demo.gui_components.utils;

import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemUtil {

    private static final Logger LOGGER = LogManager.getLogger(SystemUtil.class);

    public static String getSystemOsName() throws UnknownOsException {
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows")) return "Windows";
        if (osName.contains("Mac")) return "Mac";
        if (osName.contains("Linux")) return "Linux";
        throw new UnknownOsException("Unknown os name");
    }
}
