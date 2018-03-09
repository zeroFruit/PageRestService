package com.page.be.PageRest.domain.user;

public class UserDto {
    private Long id;
    private String displayName;
    private String email;
    private String pw;
    private String profile;

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public String getProfile() {
        return profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
