package com.dkasiian.entiry.form;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

public class UserForm {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .toString();
    }
}
