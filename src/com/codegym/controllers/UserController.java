package com.codegym.controllers;

import com.codegym.DAO.UserDAO;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home", "Login",new Login() );
        return modelAndView;
    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String displayLogin(Model model) {
//        model.addAttribute("login", new Login());
//        return "home";
//    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDAO.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
