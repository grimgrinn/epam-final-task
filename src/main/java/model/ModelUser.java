package model;

import dao.UserDao;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import settings.Constants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by egorov.a on 05.08.2016.
 */
public class ModelUser {
    private static final Logger MEGALOG = LogManager.getLogger(ModelUser.class);

    /**
     * Авторизация
     * @param email логин
     * @param password пароль
     * @return null или объект пользователя
     */
    public User login(final String email, final String password) {
        if (email == null || password == null) {
            return null;
        }

        UserDao dao = new UserDao();
        User user = dao.getByEmail(email);
        if (user == null) {
            return null;
        }

        if (!verifyPassword(password, user.getPassword())) {
            return null;
        }
        return user;
    }

    /**
     * Проверка совпадения пароля
     * @param password пароль
     * @param encodedPassword закодированный пароль
     * @return bool
     */
    private boolean verifyPassword(final String password, final String encodedPassword) {
        if (password == null || encodedPassword == null) {
            return false;
        }
        return encodedPassword.equals(encryptPassword(password));
    }

    private String encryptPassword(final String password) {
        try {
            String passwordWithSalt = password + Constants.PASSWORD_SALT;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passwordWithSalt.getBytes("UTF-8"));
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aDigest : digest) {
                sb.append(Integer.toHexString(0xff & aDigest));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            MEGALOG.error("encrypt password error", e);
        }
        return null;
    }

    /**
     * Валидация данных регистрации
     * @param firstName имя
     * @param email логин
     * @param password пароль
     * @return сообщения об ошибке или CORRECT_SIGNUP
     */
    private ArrayList<StatusUserDataMessages> validateSignupUserData(final String firstName, final String email, final String password) {
        ArrayList<StatusUserDataMessages> validate = new ArrayList<>();

        if (firstName == null || firstName.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_NAME);
        }
        if (email == null || email.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_LOGIN);
        }
        if (password == null || password.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_PASSWORD);
        } else if (!isValidPassword(password)) {
            validate.add(StatusUserDataMessages.PASSWORD_INCORRECT);
        }

        UserDao dao = new UserDao();
        User findLogin = dao.getByEmail(email);
        if (findLogin != null) {
            validate.add(StatusUserDataMessages.LOGIN_EXIST);
        }

        if (validate.size() == 0) {
            validate.add(StatusUserDataMessages.CORRECT_SIGNUP);
        }

        return validate;
    }

    private boolean isValidPassword(final String password) {
        return !(password.length() < Constants.PASSWORD_LENGTH_MIN || password.length() > Constants.PASSWORD_LENGTH_MAX);
    }
    /**
     * Создаёт пользователя
     * @param lastName имя
     * @param firstName имя
     * @param email логин
     * @param password пароль
     * @return ошибки создания или CORRECT_SIGNUP
     */
    public ArrayList<StatusUserDataMessages> createUser(final String email, final String lastName,final String firstName, final String password) {
        ArrayList<StatusUserDataMessages> validate = validateSignupUserData(firstName, email, password);
        if (validate.get(0) == StatusUserDataMessages.CORRECT_SIGNUP) {
            String encodedPassword = encryptPassword(password);
            if (encodedPassword != null) {
                User user = new User(email, firstName, lastName, encodedPassword);
                UserDao dao = new UserDao();
                dao.create(user);
            } else {
                validate.add(StatusUserDataMessages.UNKNOWN_ERROR);
            }
        }

        return validate;
    }
}
