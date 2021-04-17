package edu.tyut.wrx.brain.model;

/**
 * 教育水平字典类
 */
public class EduLevel {
    private Integer id;
    private String levelName;

    public EduLevel() {
    }

    public EduLevel(Integer id, String levelName) {
        this.id = id;
        this.levelName = levelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return "EduLevel{" +
                "id=" + id +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}
