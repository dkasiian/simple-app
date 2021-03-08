package com.dkasiian.service;

import com.dkasiian.entiry.User;
import com.dkasiian.entiry.form.UserForm;

public interface UserService {

    User createUser(UserForm user);

    User login(String username, String password);
}
