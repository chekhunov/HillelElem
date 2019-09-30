package com.hillel.library.user;

import com.hillel.library.entity.Abonent;
import com.hillel.library.entity.Role;

public class LoginService {

    public Abonent login(String username, String password, boolean login) {
        if (login) {
            return new Abonent(1, 123, "vasya", Role.ADMIN, "");
        } else {
            return null;
        }
    }

}
