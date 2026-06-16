package platform.entity;

public class Collect {
    private Integer id;
    private Integer userId;
    private Integer mbId;
    private String createTime;

    public Collect() {
    }

    public Collect(Integer id, Integer userId, Integer mbId, String createTime) {
        this.id = id;
        this.userId = userId;
        this.mbId = mbId;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}