package com.extralent.info.config;

import com.extralent.Extralent;
import com.extralent.proxy.common.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_SPAWNS = "spawns";

    public static void readConfig() {
        Configuration config = CommonProxy.config;
        try {config.load();
         initGeneralConfig(config);
         initOreConfig(config);
        } catch (Exception e1) {
            Extralent.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
    }

    private static void initOreConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_SPAWNS, "Ore configuration");
    }
}
