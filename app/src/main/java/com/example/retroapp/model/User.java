package com.example.retroapp.model;

public class User {

    private String login;



    public User(String login, Integer id) {
        super();
        this.login = login;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
