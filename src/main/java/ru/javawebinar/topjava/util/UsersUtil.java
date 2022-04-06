package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class UsersUtil {

    public static final List<User> users = Arrays.asList(
            new User(1, "Zadmin", "admin@admin.ru", "12", 2000, true, EnumSet.of(Role.USER, Role.ADMIN)),
            new User(2,"user","user@user.ru","13", 1800,true, EnumSet.of(Role.USER))
            );
}
