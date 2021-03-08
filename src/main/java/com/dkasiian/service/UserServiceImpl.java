package com.dkasiian.service;

import com.dkasiian.entiry.User;
import com.dkasiian.entiry.form.UserForm;
import com.dkasiian.exception.UserIsExistException;
import com.dkasiian.exception.UserNotFoundException;
import com.dkasiian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserForm user) {
        checkIfUserExist(user);
        return userRepository.save(new User(user));
    }

    private void checkIfUserExist(UserForm user) {
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new UserIsExistException();
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password))
            return user;
        else
            throw new UserNotFoundException();
    }
}
