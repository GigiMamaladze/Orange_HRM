package com.solvd.project.carina.demo.gui_components.utils;

import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import com.solvd.project.carina.demo.gui_components.utils.enums.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemUtil {

    private static final Logger LOGGER = LogManager.getLogger(SystemUtil.class);

    public static Platform getSystemOsName() throws UnknownOsException {
        String osName = System.getProperty("os.name");
        String[] split = osName.split("\\s+");
        LOGGER.info(split[0]);
        Platform platform = Platform.getByName(split[0]);
        return platform;
    }
}
