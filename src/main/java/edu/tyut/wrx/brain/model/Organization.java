package edu.tyut.wrx.brain.model;

/**
 * 机构类
 */
public class Organization {
    private Integer id;
    private String orgName;
    private String orgPwd;

    public Organization() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgPwd() {
        return orgPwd;
    }

    public void setOrgPwd(String orgPwd) {
        this.orgPwd = orgPwd;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                ", orgPwd='" + orgPwd + '\'' +
                '}';
    }
}
