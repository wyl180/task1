package pojo;
/**
 * @Author 韦延伦
 * @Description 实体类
 * @Date 2020/6/14 21:00
 * @version 1.0
 **/
public class Student {
    /**
     * 学生id
     */
    private int id;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 入学时间
     */
    private String enterTime;
    /**
     *学号
     */
    private String studentNumber;
    /**
     *qq号
     */
    private String qqNumber;
    /**
     *毕业学校
     */
    private String school;
    /**
     *修真类型
     */
    private String type;
    /**
     *日报链接
     */
    private String logLink;
    /**
     *立愿
     */
    private String slogan;
    /**
     *辅导师兄
     */
    private String brother;
    /**
     *创建时间
     */
    private long createTime;
    /**
     *更新时间
     */
    private long updateTime;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLogLink(String logLink) {
        this.logLink = logLink;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public String getSchool() {
        return school;
    }

    public String getType() {
        return type;
    }

    public String getLogLink() {
        return logLink;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getBrother() {
        return brother;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }
}

