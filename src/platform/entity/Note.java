package platform.entity;

public class Note {
    private Integer id;
    private Integer userId;
    private Integer mbId;
    private String content;

    private Integer star;
    private String img;
    private String createTime;

    private String nickname;
    private String UserAvatar;

    public String getUserAvatar() {
        return UserAvatar;
    }

    public void setUserAvatar(String UserAvatar) {
        this.UserAvatar = UserAvatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public Note() {
    }

    public Note(Integer id, Integer userId, Integer mbId, String content, Integer star, String img, String createTime) {
        this.id = id;
        this.userId = userId;
        this.mbId = mbId;
        this.content = content;
        this.star = star;
        this.img = img;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMbId() {
        return mbId;
    }

    public void setMbId(Integer mbId) {
        this.mbId = mbId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}