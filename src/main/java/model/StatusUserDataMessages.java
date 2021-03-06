package model;

/**
 * Статусы обработки формы регистрации
 */
public enum StatusUserDataMessages {
    EMPTY_NAME,
    EMPTY_LASTNAME,
    EMPTY_LOGIN,
    EMPTY_PASSWORD,
    PASSWORD_ERROR,
    LOGIN_EXIST,
    CORRECT_SIGNUP,
    CORRECT_UPDATE,
    UNKNOWN_ERROR,
    PASSWORD_NOT_MATCH,
    PASSWORD_INCORRECT,
    EMAIL_INCORRECT
}
