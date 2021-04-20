package edu.tyut.wrx.brain.model;

import java.util.Date;
import java.util.List;

/**
 * 游戏记录数据传输类
 */
public class RecordDTO {
    /**
     * 游戏记录id
     */
    private Integer id;
    /**
     * 用户
     */
    private User user;
    /**
     * 游戏得分集合
     */
    private List<gameAndScore> gameAndScores;
    /**
     * 日期
     */
    private Date gameDate;

    /**
     * 日期-字符串 yyyy-MM-dd HH:mm:ss
     */
    private String gameDateStr;

    public RecordDTO() {
    }

    public RecordDTO(Integer id, User user, Organization organization, List<gameAndScore> gameAndScores, Date gameDate) {
        this.id = id;
        this.user = user;
        this.gameAndScores = gameAndScores;
        this.gameDate = gameDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<gameAndScore> getGameAndScores() {
        return gameAndScores;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "id=" + id +
                ", user=" + user +
                ", gameAndScores=" + gameAndScores +
                ", gameDate=" + gameDate +
                ", gameDateStr='" + gameDateStr + '\'' +
                '}';
    }

    public void setGameAndScores(List<gameAndScore> gameAndScores) {
        this.gameAndScores = gameAndScores;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameDateStr() {
        return gameDateStr;
    }

    public void setGameDateStr(String gameDateStr) {
        this.gameDateStr = gameDateStr;
    }
}
