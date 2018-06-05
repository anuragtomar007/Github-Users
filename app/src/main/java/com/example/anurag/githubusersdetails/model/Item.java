package com.example.anurag.githubusersdetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    @SerializedName("repos_url")
    @Expose
    private String repoUrl;


    @SerializedName("followers_url")
    @Expose
    private String followersUrl;


//    public Item(String login, String avatarUrl, String htmlUrl) {
//        this.login = login;
//        this.avatarUrl = avatarUrl;
//        this.htmlUrl = htmlUrl;
//    }


    public Item(String login, String avatarUrl, String htmlUrl, String repoUrl, String followersUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
        this.repoUrl = repoUrl;
        this.followersUrl = followersUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getRepoUrl() {

        return repoUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
