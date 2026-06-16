package platform.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieBook {
    private Integer id;
    private Integer type;
    private Integer categoryId;
    private String title;
    private String cover;
    private String intro;
    private Double score;
    private Integer hot;
    private Integer auditStatus;
    private Integer applyUserId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String createTime;
    
    private String categoryName;
    private Integer noteCount;

    public MovieBook() {
    }

    public MovieBook(Integer id, Integer type, Integer categoryId, String title, String cover, String intro, Double score, Integer hot, Integer auditStatus, Integer applyUserId, String createTime) {
        this.id = id;
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
        this.cover = cover;
        this.intro = intro;
        this.score = score;
        this.hot = hot;
        this.auditStatus = auditStatus;
        this.applyUserId = applyUserId;
        this.createTime = createTime;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(Integer noteCount) {
        this.noteCount = noteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}