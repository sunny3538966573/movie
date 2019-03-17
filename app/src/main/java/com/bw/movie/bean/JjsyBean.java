package com.bw.movie.bean;

import java.util.List;

/**
 * Created by 1607c王晴
 * date 2019/3/15
 * Describe:
 */
public class JjsyBean {

        /**
         * followMovie : 2
         * id : 16
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg
         * name : 碟中谍6：全面瓦解
         * rank : 0
         * releaseTime : 1569081600000
         * releaseTimeShow : 2019-09-22
         * summary : 有时好意会造成恶果，人反而被自己所造成的结果所困扰。伊桑·亨特（汤姆·克鲁斯 饰）和他的IMF团队（亚历克·鲍德温、西蒙·佩吉、文·瑞姆斯）将在最新的电影《碟中谍6：全面瓦解》中再度回归，他们会与观众们熟悉的盟友（丽贝卡·弗格森、米歇尔·莫娜汉）一起与时间赛跑，应对一次任务中出现的意外。亨利·卡维尔、安吉拉·贝塞特和凡妮莎·柯比也将加入本片的演员阵容，电影制片人克里斯托夫·迈考利将会再度担任导演。
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
