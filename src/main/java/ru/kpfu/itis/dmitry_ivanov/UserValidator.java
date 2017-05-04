package ru.kpfu.itis.dmitry_ivanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.dmitry_ivanov.model.User;
import ru.kpfu.itis.dmitry_ivanov.services.UserService;

/**
 * Created by Dmitry on 02.05.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
            errors.rejectValue("username", "Login must be over 6 characters");
        }

        if (userService.findByUsername(user.getLogin()) != null) {
            errors.rejectValue("username", "Login already exsists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Password must be over 6 characters");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Wrong confirm password");
        }
    }
}
