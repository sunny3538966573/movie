package com.bw.movie.bean;

import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class ZzsyBean {

        /**
         * followMovie : 2
         * id : 11
         * imageUrl : http://172.17.8.100/images/movie/stills/jcs/jcs1.jpg
         * name : 巨齿鲨
         * rank : 0
         * releaseTime : 1536336000000
         * releaseTimeShow : 2018-09-08
         * summary : 一项由中国主导的国际科研项目，正在马里亚纳海沟深处进行时，遭遇未知生物攻击，科研人员被困海底。前美国海军陆战队深海潜水专家乔纳斯·泰勒（杰森·斯坦森 饰）受命前往营救，再度遭遇数年前曾经在深海给自己留下终身难以磨灭记忆的史前生物巨齿鲨。乔纳斯联手科研项目中的中国女科学家张苏茵（李冰冰 饰）成功营救了被困人员，但营救行动却意外造成了巨齿鲨逃离深海。当史前巨兽重返浅海，人类将为自己对大自然的贪婪付出惨重的代价......
         */

        private int followMovie;
        private int id;
        private String imageUrl;
        private String name;
        private int rank;
        private long releaseTime;
        private String releaseTimeShow;
        private String summary;

        public int getFollowMovie() {
            return followMovie;
        }

        public void setFollowMovie(int followMovie) {
            this.followMovie = followMovie;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getReleaseTimeShow() {
            return releaseTimeShow;
        }

        public void setReleaseTimeShow(String releaseTimeShow) {
            this.releaseTimeShow = releaseTimeShow;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

}
