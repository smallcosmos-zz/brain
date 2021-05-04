package edu.tyut.wrx.brain.model;

public class Game {
    /**
     * 游戏id
     */
    private Integer id;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 游戏描述
     */
    private String description;

    public Game() {
    }

    public Game(Integer id, String gameName, String description) {
        this.id = id;
        this.gameName = gameName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
