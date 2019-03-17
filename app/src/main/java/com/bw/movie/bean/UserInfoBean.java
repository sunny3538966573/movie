package com.bw.movie.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 1607c王晴
 * date 2019/3/13
 * Describe:
 */
@DatabaseTable(tableName ="movie")
public class UserInfoBean {
    /**
     * birthday : 951148800000
     * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
     * id : 12109
     * lastLoginTime : 1552397629000
     * nickName : 柚子皮
     * phone : 15256478902
     * sex : 2
     */
    @DatabaseField(columnName = "birthday")
    private long birthday;
    @DatabaseField(columnName = "headPic")
    private String headPic;
    @DatabaseField(generatedId =true,columnName = "_id")
    private int id;
    @DatabaseField(columnName = "lastLoginTime")
    private long lastLoginTime;
    @DatabaseField(columnName = "nickName")
    private String nickName;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "sex")
    private int sex;
    @DatabaseField(columnName = "sessionId")
    private String sessionId;
    @DatabaseField(columnName = "stats")
    private int stats;
    @DatabaseField(columnName = "userId")
    private int userId;

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserInfoBean(long birthday, String headPic, int id, long lastLoginTime, String nickName, String phone, int sex, String sessionId, int stats, int userId) {
        this.birthday = birthday;
        this.headPic = headPic;
        this.id = id;
        this.lastLoginTime = lastLoginTime;
        this.nickName = nickName;
        this.phone = phone;
        this.sex = sex;
        this.sessionId = sessionId;
        this.stats = stats;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "birthday=" + birthday +
                ", headPic='" + headPic + '\'' +
                ", id=" + id +
                ", lastLoginTime=" + lastLoginTime +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", sessionId='" + sessionId + '\'' +
                ", stats=" + stats +
                ", userId=" + userId +
                '}';
    }

    public UserInfoBean() {
    }
}
