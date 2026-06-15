package platform.entity;

public class Likes {
    private Integer id;
    private Integer userId;
    private Integer noteId;
    private String createTime;

    public Likes() {
    }

    public Likes(Integer id, Integer userId, Integer noteId, String createTime) {
        this.id = id;
        this.userId = userId;
        this.noteId = noteId;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}