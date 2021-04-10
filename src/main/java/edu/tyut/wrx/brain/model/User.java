package edu.tyut.wrx.brain.model;

/**
 * 患者信息类
 */
public class User {

    /**
     * 就诊卡号
     */
    private String id;
    /**
     * 姓名
     */
    private String userName;
    /**
     * 性别 0:女；1：男
     */
    private Integer userGender;
    /**
     * 年龄
     */
    private Integer userAge;
    /**
     * 教育水平
     * 0：未受过正规教育；1：小学；2：初中；
     * 3：中专；4、高中；5：大专；6、本科；7：硕士；
     * 8：博士
     */
    private Integer userEduLevel;
    /**
     * 备注
     */
    private String note;

    public User() {
    }

    public User(String id, String userName, Integer userGender, Integer userAge, Integer userEduLevel, String note) {
        this.id = id;
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userEduLevel = userEduLevel;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserEduLevel() {
        return userEduLevel;
    }

    public void setUserEduLevel(Integer userEduLevel) {
        this.userEduLevel = userEduLevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userAge=" + userAge +
                ", userEduLevel=" + userEduLevel +
                ", note='" + note + '\'' +
                '}';
    }
}
