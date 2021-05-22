package edu.tyut.wrx.brain.model;

import java.util.Date;

/**
 * 游戏记录表
 */
public class Record {
    /**
     * 游戏记录id(自增，不需要传)
     */
    private Integer id;
    /**
     * 用户就诊卡号
     */
    private String userId;
    /**
     * 机构id
     */
    private Integer orgId;
    /**
     * 游戏id
     */
    private Integer gameId;
    /**
     * 开始游戏时间
     */
    private Date startTime;
    /**
     *
     * 游戏完成时间
     */
    private Date endTime;
    /**
     * 游戏得分
     */
    private Integer score;

    /**
     * 正确个数
     */
    private int correctNum;

    /**
     * 错误个数
     */
    private int errorNum;

    /**
     * 游戏时长
     */
    private Long gameTime;

    public Record() {
    }

    public Record(String userId, Integer orgId, Integer gameId, Date startTime, Date endTime, Integer score, int correctNum, int errorNum, Long gameTime) {
        this.userId = userId;
        this.orgId = orgId;
        this.gameId = gameId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
        this.correctNum = correctNum;
        this.errorNum = errorNum;
        this.gameTime = gameTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(int correctNum) {
        this.correctNum = correctNum;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    public Long getGameTime() {
        return gameTime;
    }

    public void setGameTime(Long gameTime) {
        this.gameTime = gameTime;
    }
}
