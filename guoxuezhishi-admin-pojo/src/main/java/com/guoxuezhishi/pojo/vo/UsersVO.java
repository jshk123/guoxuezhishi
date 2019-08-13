package com.guoxuezhishi.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "用户对象", description = "这是用户对象")
public class UsersVO implements Serializable {
    @ApiModelProperty(hidden = true)
    private String id;
    @ApiModelProperty(hidden = true)
    private String userToken;
    @ApiModelProperty(value = "用户名", name = "username", example = "zhangsan", required = true)
    private String username;
    @ApiModelProperty(value = "密码", name = "password", example = "zhangsan123", required = true)
//    @JsonIgnore
    private String password;
    @ApiModelProperty(hidden = true)
    private String faceImage;

    private String nickname;
    @ApiModelProperty(hidden = true)
    private Integer fansCounts;
    @ApiModelProperty(hidden = true)
    private Integer followCounts;
    @ApiModelProperty(hidden = true)
    private Integer receiveLikeCounts;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UsersVO{" +
                "id='" + id + '\'' +
                ", userToken='" + userToken + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", faceImage='" + faceImage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", fansCounts=" + fansCounts +
                ", followCounts=" + followCounts +
                ", receiveLikeCounts=" + receiveLikeCounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersVO usersVO = (UsersVO) o;
        return Objects.equals(id, usersVO.id) &&
                Objects.equals(userToken, usersVO.userToken) &&
                Objects.equals(username, usersVO.username) &&
                Objects.equals(password, usersVO.password) &&
                Objects.equals(faceImage, usersVO.faceImage) &&
                Objects.equals(nickname, usersVO.nickname) &&
                Objects.equals(fansCounts, usersVO.fansCounts) &&
                Objects.equals(followCounts, usersVO.followCounts) &&
                Objects.equals(receiveLikeCounts, usersVO.receiveLikeCounts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userToken, username, password, faceImage, nickname, fansCounts, followCounts, receiveLikeCounts);
    }

    public String getUserToken() {

        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getFansCounts() {
        return fansCounts;
    }

    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    public Integer getFollowCounts() {
        return followCounts;
    }

    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }

}