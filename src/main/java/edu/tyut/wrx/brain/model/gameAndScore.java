package edu.tyut.wrx.brain.model;

public class gameAndScore {
    private String gameName;
    private Integer score;
    private Integer correctNum;
    private Integer errorNum;
    private Long gameTime;

    public gameAndScore() {
    }

    public gameAndScore(String gameName, Integer score, Integer correctNum, Integer errorNum, Long gameTime) {
        this.gameName = gameName;
        this.score = score;
        this.correctNum = correctNum;
        this.errorNum = errorNum;
        this.gameTime = gameTime;
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

    public Integer getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(Integer correctNum) {
        this.correctNum = correctNum;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public Long getGameTime() {
        return gameTime;
    }

    public void setGameTime(Long gameTime) {
        this.gameTime = gameTime;
    }


    @Override
    public String toString() {
        return "gameAndScore{" +
                "gameName='" + gameName + '\'' +
                ", score=" + score +
                ", correctNum=" + correctNum +
                ", errorNum=" + errorNum +
                ", gameTime=" + gameTime +
                '}';
    }
}
