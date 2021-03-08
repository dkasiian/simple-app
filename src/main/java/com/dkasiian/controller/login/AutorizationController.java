package com.dkasiian.controller.login;

import com.dkasiian.entiry.User;
import com.dkasiian.entiry.form.UserForm;
import com.dkasiian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AutorizationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserForm login(@RequestBody UserForm createUser) {
        userService.login(createUser.getUsername(), createUser.getPassword());
        return createUser;
    }

    @RequestMapping(value = "reg", method = RequestMethod.POST)
    public User reg(@RequestBody UserForm createUser) {
        System.out.println(createUser);
        return userService.createUser(createUser);
    }
}
