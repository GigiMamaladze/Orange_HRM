package com.solvd.project.carina.demo.gui_components.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemUtil {

    private static final Logger LOGGER = LogManager.getLogger(SystemUtil.class);

    public static String getSystemOsName() {
        String osName = System.getProperty("os.name");
        LOGGER.info(osName);
        return osName;
    }
}
