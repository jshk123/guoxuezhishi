package generator;

import java.io.Serializable;

/**
 * users
 * @author 
 */
public class Users implements Serializable {
    private String id;

    private String username;

    private String password;

    private String faceImage;

    private String nickname;

    private Integer fansCounts;

    private Integer followCounts;

    private Integer receiveLikeCounts;

    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getFaceImage() == null ? other.getFaceImage() == null : this.getFaceImage().equals(other.getFaceImage()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getFansCounts() == null ? other.getFansCounts() == null : this.getFansCounts().equals(other.getFansCounts()))
            && (this.getFollowCounts() == null ? other.getFollowCounts() == null : this.getFollowCounts().equals(other.getFollowCounts()))
            && (this.getReceiveLikeCounts() == null ? other.getReceiveLikeCounts() == null : this.getReceiveLikeCounts().equals(other.getReceiveLikeCounts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getFaceImage() == null) ? 0 : getFaceImage().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getFansCounts() == null) ? 0 : getFansCounts().hashCode());
        result = prime * result + ((getFollowCounts() == null) ? 0 : getFollowCounts().hashCode());
        result = prime * result + ((getReceiveLikeCounts() == null) ? 0 : getReceiveLikeCounts().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", faceImage=").append(faceImage);
        sb.append(", nickname=").append(nickname);
        sb.append(", fansCounts=").append(fansCounts);
        sb.append(", followCounts=").append(followCounts);
        sb.append(", receiveLikeCounts=").append(receiveLikeCounts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}