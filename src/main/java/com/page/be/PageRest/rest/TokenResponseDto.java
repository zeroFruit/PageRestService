package com.page.be.PageRest.rest;

public class TokenResponseDto {
    private String accessToken;
    private String profile;
    private String email;
    private String displayName;
    private Long id;

    public TokenResponseDto() {}

    public TokenResponseDto(String accessToken, String profile, String email, String displayName, Long id) {
        this.accessToken = accessToken;
        this.profile = profile;
        this.email = email;
        this.displayName = displayName;
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
