package com.page.be.PageRest.domain;

public class JwtUser {
    private long id;
    private String email;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
