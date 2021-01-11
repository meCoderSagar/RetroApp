package com.example.retroapp.model;

public class Post {

    private String repository_url;
    private User user;
    private String state;
    private Integer id;


    public Post(String repositoryUrl, User user, String state,Integer id) {
        super();
        this.repository_url = repositoryUrl;
        this.user = user;
        this.state = state;
        this.id = id;
    }

    public String getRepositoryUrl() {
        return repository_url;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repository_url = repositoryUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
