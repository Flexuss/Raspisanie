package ru.kpfu.itis.dmitry_ivanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dmitry_ivanov.UserValidator;
import ru.kpfu.itis.dmitry_ivanov.model.User;
import ru.kpfu.itis.dmitry_ivanov.services.SecurityService;
import ru.kpfu.itis.dmitry_ivanov.services.UserService;

/**
 * Created by Dmitry on 25.04.2017.
 */
@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping("/login")
    public String login(Model model, String error, String logout){
        if(error!=null){
            model.addAttribute("error","Username or password is incorrect.");
        }

        if(logout!=null){
            model.addAttribute("message","Logged out successfully");
        }
        return "login";
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userform",new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("password") String password, @RequestParam("user") String user,@RequestParam("confirmPassword") String confirmPassword, Model model){

        User userForm = new User();
        userForm.setPassword(password);
        userForm.setLogin(user);
        userForm.setConfirmPassword(confirmPassword);

        userService.save(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getPassword());

        return "redirect:/home";
    }

    @RequestMapping("/access_denied")
    public String denied(){
        return "redirect:/home";
    }

}
