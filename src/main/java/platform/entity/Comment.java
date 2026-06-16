package platform.entity;

public class Comment {
    private Integer id;
    private Integer userId;
    private Integer noteId;
    private String content;
    private String createTime;
    private String nickname;

    public String getUserAvatar() {
        return UserAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        UserAvatar = userAvatar;
    }

    private String UserAvatar;

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }


    public Comment() {
    }

    public Comment(Integer id, Integer userId, Integer noteId, String content, String createTime) {
        this.id = id;
        this.userId = userId;
        this.noteId = noteId;
        this.content = content;
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

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}