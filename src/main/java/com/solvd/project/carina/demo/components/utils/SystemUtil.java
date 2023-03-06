package com.solvd.project.carina.demo.components.utils;

import com.solvd.project.carina.demo.components.enums.utils.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemUtil {

    private static final Logger LOGGER = LogManager.getLogger(SystemUtil.class);

    public static Platform getSystemOSName() {
        String osName = System.getProperty("os.name");
        String[] split = osName.split("\\s+");
        LOGGER.info("Current OS: " + split[0]);
        return Platform.getByName(split[0]);
    }
}
