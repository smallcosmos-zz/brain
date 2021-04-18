package edu.tyut.wrx.brain.model;

public class gameAndScore {
    private String gameName;
    private Integer score;

    public gameAndScore() {
    }

    public gameAndScore(String gameName, Integer score) {
        this.gameName = gameName;
        this.score = score;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "gameAndScore{" +
                "gameName='" + gameName + '\'' +
                ", score=" + score +
                '}';
    }
}
