package com.dkasiian.entiry;

import com.dkasiian.entiry.form.UserForm;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Getter
    @Setter
    @Size(groups = {UserForm.class}, min = 3, max = 128, message = "{Size.user.usernameOrPassword}")
    @NotNull(groups = {UserForm.class}, message = "{NotNull.user.username}")
    private String username;

    @Getter
    @Setter
    @Size(groups = {UserForm.class}, min = 3, max = 128, message = "{Size.user.usernameOrPassword}")
    @NotNull(groups = {UserForm.class}, message = "{NotNull.user.password}")
    private String password;

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    public User(UserForm createUser) {
        setPassword(createUser.getPassword());
        setUsername(createUser.getUsername());
    }

    public User() {
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .toString();
    }
}
