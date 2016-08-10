package model;

import languages.Languages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import settings.Constants;


public class LanguageModel {
    private static final Logger MEGALOG = LogManager.getLogger(LanguageModel.class);
    public Languages getLanguage(String param, Languages currentLanguage) {
        Languages lang;
        if (param != null) {
            switch (param) {
                case "en":
                    lang = Languages.EN;
                    break;
                case "ru":
                    lang = Languages.RU;
                    break;
                default:
                    MEGALOG.warn("try to change invalid language " + param);
                    lang = Constants.DEFAULT_LOCALE;
                    break;
            }
            MEGALOG.info("change language to " + lang);
        } else {
            if (currentLanguage == null) {
                MEGALOG.info("set default language");
                lang = Constants.DEFAULT_LOCALE;
            } else {
                lang = currentLanguage;
            }
        }
        return lang;
    }
}
