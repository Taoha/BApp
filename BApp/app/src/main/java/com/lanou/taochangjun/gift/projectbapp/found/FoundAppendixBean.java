package com.lanou.taochangjun.gift.projectbapp.found;

import java.util.List;

/**
 * Created by dllo on 17/2/28.
 */

public class FoundAppendixBean {


    /**
     * id : 14847213448701
     * name : 游戏杂谈
     * parentId : -1
     * parentName : null
     * show : 1
     * icon : http://bobo-public.nosdn.127.net/bobo_1484721371691_20371230.png
     * background :
     * checked : false
     * videoList : []
     * videoSetList : [{"name":"史丹利Studio STN快报","cover":"http://bobo-public.nosdn.127.net/bobo_1482733060277_78542176.jpg","intro":"","channelName":"史丹利Studio","videoCount":14825908044251,"playCount":57365,"degree":5,"userId":-474161388681954277,"userIdStr":"-474161388681954277","avatar":"http://bobo-public.nosdn.127.net/bobo_1478513987124_14885102.jpg","sid":14825908044251,"videoId":14879295193261},{"name":"暴走玩啥游戏 第二季","cover":"http://bobo-public.nosdn.127.net/bobo_1485054769258_92593480.jpg","intro":"","channelName":"暴走玩啥游戏","videoCount":14734218208751,"playCount":268212,"degree":5,"userId":3907009683567335148,"userIdStr":"3907009683567335148","avatar":"http://bobo-public.nosdn.127.net/bobo_1466409470857_96307059.jpg","sid":14734218208751,"videoId":14879291573861},{"name":"折腾5号 坦克世界","cover":"http://bobo-public.nosdn.127.net/bobo_1469203395094_63981739.png","intro":"","channelName":"折腾5号","videoCount":14690683620521,"playCount":366552,"degree":3,"userId":-9193852356750546134,"userIdStr":"-9193852356750546134","avatar":"http://bobo-public.nosdn.127.net/bobo_1468918448823_24619923","sid":14690683620521,"videoId":14879291577551},{"name":"折腾5号 番外","cover":"http://bobo-public.nosdn.127.net/bobo_1484735491307_98805303.jpg","intro":"","channelName":"折腾5号","videoCount":14707955973971,"playCount":143776,"degree":3,"userId":-9193852356750546134,"userIdStr":"-9193852356750546134","avatar":"http://bobo-public.nosdn.127.net/bobo_1468918448823_24619923","sid":14707955973971,"videoId":14871242257051},{"name":"狂丸菌 正片","cover":"http://bobo-public.nosdn.127.net/bobo_1479103931444_49940642.jpg","intro":"","channelName":"狂丸菌","videoCount":14787714763151,"playCount":260365,"degree":1,"userId":-5223303856408230200,"userIdStr":"-5223303856408230200","avatar":"http://bobo-public.nosdn.127.net/bobo_1484891649320_89294610.jpg","sid":14787714763151,"videoId":14871242250311},{"name":"史丹利Studio 屎蛋说","cover":"http://bobo-public.nosdn.127.net/bobo_1478658147275_36938585.jpg","intro":"","channelName":"史丹利Studio","videoCount":14778324597841,"playCount":200909,"degree":1,"userId":-474161388681954277,"userIdStr":"-474161388681954277","avatar":"http://bobo-public.nosdn.127.net/bobo_1478513987124_14885102.jpg","sid":14778324597841,"videoId":14871242253281},{"name":"姑夫游戏圈 正片","cover":"http://bobo-public.nosdn.127.net/bobo_1477241677651_40516548.png","intro":"","channelName":"姑夫游戏圈","videoCount":14627905300571,"playCount":325994,"degree":0,"userId":-4840703379031864104,"userIdStr":"-4840703379031864104","avatar":"http://bobo-public.nosdn.127.net/bobo_1463366385607_25538383","sid":14627905300571,"videoId":14848195215331},{"name":"总攻立早大人 Cube Escape","cover":"http://bobo-public.nosdn.127.net/bobo_1479296981563_70649877.png","intro":"","channelName":"总攻立早大人","videoCount":14787721573311,"playCount":45925,"degree":0,"userId":1207987402647404704,"userIdStr":"1207987402647404704","avatar":"http://bobo-public.nosdn.127.net/bobo_1460728695357_31504479","sid":14787721573311,"videoId":14787721573811}]
     */

    private long id;
    private String name;
    private int parentId;
    private Object parentName;
    private int show;
    private String icon;
    private String background;
    private boolean checked;
    private List<?> videoList;
    private List<VideoSetListBean> videoSetList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Object getParentName() {
        return parentName;
    }

    public void setParentName(Object parentName) {
        this.parentName = parentName;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<?> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<?> videoList) {
        this.videoList = videoList;
    }

    public List<VideoSetListBean> getVideoSetList() {
        return videoSetList;
    }

    public void setVideoSetList(List<VideoSetListBean> videoSetList) {
        this.videoSetList = videoSetList;
    }

    public static class VideoSetListBean {
        /**
         * name : 史丹利Studio STN快报
         * cover : http://bobo-public.nosdn.127.net/bobo_1482733060277_78542176.jpg
         * intro :
         * channelName : 史丹利Studio
         * videoCount : 14825908044251
         * playCount : 57365
         * degree : 5
         * userId : -474161388681954277
         * userIdStr : -474161388681954277
         * avatar : http://bobo-public.nosdn.127.net/bobo_1478513987124_14885102.jpg
         * sid : 14825908044251
         * videoId : 14879295193261
         */

        private String name;
        private String cover;
        private String intro;
        private String channelName;
        private long videoCount;
        private int playCount;
        private int degree;
        private long userId;
        private String userIdStr;
        private String avatar;
        private long sid;
        private long videoId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public long getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(long videoCount) {
            this.videoCount = videoCount;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getDegree() {
            return degree;
        }

        public void setDegree(int degree) {
            this.degree = degree;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUserIdStr() {
            return userIdStr;
        }

        public void setUserIdStr(String userIdStr) {
            this.userIdStr = userIdStr;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public long getSid() {
            return sid;
        }

        public void setSid(long sid) {
            this.sid = sid;
        }

        public long getVideoId() {
            return videoId;
        }

        public void setVideoId(long videoId) {
            this.videoId = videoId;
        }
    }
}
