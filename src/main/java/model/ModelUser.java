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
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ModelUser {
    private static final Logger MEGALOG = LogManager.getLogger(ModelUser.class);

    /**
     * Получает пользователя по его айди
     * @return список элементов
     */
    public User getById(final int id){
        UserDao dao = new UserDao();
        return dao.getById(id);
    }

    /**
     * Получает всех на свете юзеров
     * @return список элементов
     */
    public Collection<User> getAll() {
        UserDao dao = new UserDao();
        return dao.get();
    }

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
        System.out.println("trying to validate password -> "+password + " with this encoded password" + user.getPassword());
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
        System.out.println("this is encodede password -> " + encodedPassword);
        System.out.println("and this is encrypted passwor dfrom form -> " + encryptPassword(password));
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
    private ArrayList<StatusUserDataMessages> validateSignupUserData(final String firstName,final String lastName, final String email, final String password) {
        ArrayList<StatusUserDataMessages> validate = new ArrayList<>();
        System.out.println("now i am in validatesignupuserdata");
        if (firstName == null || firstName.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_NAME);

        }

        if (firstName == null || firstName.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_LASTNAME);

        }

        System.out.println(firstName + " is no null");
        if (email == null || email.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_LOGIN);
        }
        System.out.println(email + " is no null");
        if (password == null || password.length() == 0) {
            validate.add(StatusUserDataMessages.EMPTY_PASSWORD);
        } else if (!isValidPassword(password)) {
            validate.add(StatusUserDataMessages.PASSWORD_INCORRECT);
        }

        if(!isValidEmail(email)){
            validate.add(StatusUserDataMessages.EMAIL_INCORRECT);
        }

        System.out.println(password + " is not null and ok");

        UserDao dao = new UserDao();
        System.out.println("trying to get user by email - " + email);
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

    private boolean isValidEmail(final String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        return matcher.matches();
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
        System.out.println("trying ti validate user with "+ firstName + " " +  email + " " + password);
        ArrayList<StatusUserDataMessages> validate = validateSignupUserData(firstName, lastName, email, password);
        if (validate.get(0) == StatusUserDataMessages.CORRECT_SIGNUP) {
            String encodedPassword = encryptPassword(password);
            if (encodedPassword != null) {
                User user = new User(email, firstName, lastName, encodedPassword);
                UserDao dao = new UserDao();
                System.out.println("this is iser - > "+user);
                dao.create(user);
            } else {
                validate.add(StatusUserDataMessages.UNKNOWN_ERROR);
            }
        }

        return validate;
    }
}
