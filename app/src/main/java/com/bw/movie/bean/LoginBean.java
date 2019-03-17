package com.bw.movie.bean;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:
 */
public class LoginBean {
        /**
         * sessionId : 155239787310312109
         * userId : 12109
         * userInfo : {"birthday":951148800000,"headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":12109,"lastLoginTime":1552397629000,"nickName":"柚子皮","phone":"15256478902","sex":2}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }


}
