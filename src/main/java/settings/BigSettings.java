package settings;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Настройки социальной сети
 */
public class BigSettings {
    public static final Logger MEGALOG = LogManager.getLogger(BigSettings.class);

    private static String RESOURCE_PATH = "settings.parameters";
    private static BigSettings instance = new BigSettings();
    private ResourceBundle properties;

    public static BigSettings getInstance() {
        return instance;
    }

    public BigSettings() {
        properties = ResourceBundle.getBundle(RESOURCE_PATH);
    }

    public String getValue(String key) {
        try {
            return properties.getString(key);
        } catch (MissingResourceException e) {
            MEGALOG.error("invalid setting key");
            return null;
        }
    }
}
