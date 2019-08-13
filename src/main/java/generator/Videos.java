package generator;

import java.io.Serializable;
import java.util.Date;

/**
 * videos
 * @author 
 */
public class Videos implements Serializable {
    private String id;

    private String userId;

    private String audioId;

    private String videoDesc;

    private String videoPath;

    private Float videoSeconds;

    private Integer videoWidth;

    private Integer videoHeight;

    private String coverPath;

    private Long likeCounts;

    /**
     * 视频状态：1、发布成功；2、禁止播放，管理员操作
     */
    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAudioId() {
        return audioId;
    }

    public void setAudioId(String audioId) {
        this.audioId = audioId;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Float getVideoSeconds() {
        return videoSeconds;
    }

    public void setVideoSeconds(Float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    public Integer getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Long getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        Videos other = (Videos) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAudioId() == null ? other.getAudioId() == null : this.getAudioId().equals(other.getAudioId()))
            && (this.getVideoDesc() == null ? other.getVideoDesc() == null : this.getVideoDesc().equals(other.getVideoDesc()))
            && (this.getVideoPath() == null ? other.getVideoPath() == null : this.getVideoPath().equals(other.getVideoPath()))
            && (this.getVideoSeconds() == null ? other.getVideoSeconds() == null : this.getVideoSeconds().equals(other.getVideoSeconds()))
            && (this.getVideoWidth() == null ? other.getVideoWidth() == null : this.getVideoWidth().equals(other.getVideoWidth()))
            && (this.getVideoHeight() == null ? other.getVideoHeight() == null : this.getVideoHeight().equals(other.getVideoHeight()))
            && (this.getCoverPath() == null ? other.getCoverPath() == null : this.getCoverPath().equals(other.getCoverPath()))
            && (this.getLikeCounts() == null ? other.getLikeCounts() == null : this.getLikeCounts().equals(other.getLikeCounts()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAudioId() == null) ? 0 : getAudioId().hashCode());
        result = prime * result + ((getVideoDesc() == null) ? 0 : getVideoDesc().hashCode());
        result = prime * result + ((getVideoPath() == null) ? 0 : getVideoPath().hashCode());
        result = prime * result + ((getVideoSeconds() == null) ? 0 : getVideoSeconds().hashCode());
        result = prime * result + ((getVideoWidth() == null) ? 0 : getVideoWidth().hashCode());
        result = prime * result + ((getVideoHeight() == null) ? 0 : getVideoHeight().hashCode());
        result = prime * result + ((getCoverPath() == null) ? 0 : getCoverPath().hashCode());
        result = prime * result + ((getLikeCounts() == null) ? 0 : getLikeCounts().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", audioId=").append(audioId);
        sb.append(", videoDesc=").append(videoDesc);
        sb.append(", videoPath=").append(videoPath);
        sb.append(", videoSeconds=").append(videoSeconds);
        sb.append(", videoWidth=").append(videoWidth);
        sb.append(", videoHeight=").append(videoHeight);
        sb.append(", coverPath=").append(coverPath);
        sb.append(", likeCounts=").append(likeCounts);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}