package com.java_coding_problems_book.functional.builder_pattern.functional;

import java.util.Date;
import java.util.function.Consumer;

public final class User {

    public static void main(String[] args) {
        User user = User.build(u -> u.firstName("lESTER").lastName("Pino").email("user@yahoo.com"));
        System.out.println(user.lastname);

    }

    private final Date created;
    private String email;
    private String firstname;
    private String lastname;

    public User(Date date) {
        this.created = new Date();
    }

    public User firstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public User lastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public static User build(Consumer<User> userConsumer) {
        User newUser = new User(new Date());
        userConsumer.accept(newUser);
        return newUser;
    }
}
