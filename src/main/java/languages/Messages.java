package languages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import settings.Constants;
import java.util.*;

/**
 * Сообщения на разных языках
 */
public class Messages {
    public static final Logger MEGALOG = LogManager.getLogger(Messages.class);
    private static Map<Languages, ResourceBundle> files = new HashMap<>();

    static {
        reload();
    }

    /**
     * Загружает языковые файлы
     */
    public static void reload() {

        ResourceBundle ru = ResourceBundle.getBundle("languages.text", new Locale("ru", "RU"));

        ResourceBundle en = ResourceBundle.getBundle("languages.text", new Locale("en", "US"));
        files.put(Languages.RU, ru);
        files.put(Languages.EN, en);
    }

    /**
     * Получаем сообщение в зависимости от локали
     * По-умолчанию язык из DEFAULT_LOCALE
     * @param message ключ сообщения
     * @param locale локаль
     * @return сообщение в заданном языке или пустую строку
     */
    public static String getMessage(final String message, final Languages locale) {
        try {
            if (locale == null) {
                MEGALOG.warn("null locale");
                return files.get(Constants.DEFAULT_LOCALE).getString(message);
            }
            return files.get(locale).getString(message);
        } catch (MissingResourceException e) {
            MEGALOG.warn("Message not found", e);
            return message;
        }
    }

    /**
     * Получает сообщение из локали по-умолчанию
     * @param message ключ сообщения
     * @return сообщение или пустая строка
     */
    public static String getMessage(final String message) {
        return getMessage(message, null);
    }
}
