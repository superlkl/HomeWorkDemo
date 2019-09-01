package com.example.mythirddemo.my;

public  class RecommendBean {
    /**
     * id : 2829807251
     * type : 1
     * name : [我们出发吧] 轻快悦耳旋律伴你在路上
     * copywriter : 猜你喜欢
     * picUrl : https://p2.music.126.net/_mn6wZ4l8MNjra2_PI_xAA==/109951164252798682.jpg
     * playcount : 1375720
     * createTime : 1559731890703
     * creator : {"remarkName":null,"mutual":false,"backgroundImgId":2002210674180202,"detailDescription":"网易云音乐官方账号","defaultAvatar":false,"expertTags":null,"djStatus":10,"followed":false,"backgroundUrl":"http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg","avatarImgId":1420569024374784,"backgroundImgIdStr":"2002210674180202","accountStatus":0,"userId":1,"vipType":11,"province":110000,"avatarUrl":"https://p2.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg","authStatus":1,"userType":2,"nickname":"网易云音乐","gender":1,"birthday":-2209017600000,"city":110101,"avatarImgIdStr":"1420569024374784","description":"网易云音乐官方账号","signature":"网易云音乐是6亿人都在使用的音乐平台，致力于帮助用户发现音乐惊喜，帮助音乐人实现梦想。客服@云音乐客服 在线时间：9：00 - 24：00，如您在使用过程中遇到任何问题，欢迎私信咨询，我们会尽快回复。如果仍然不能解决您的问题，与活动相关的疑问请私信@云音乐客服","authority":3}
     * trackCount : 0
     * userId : 1
     * alg : official_playlist_sceneRank
     */

    private long id;
    private int type;
    private String name;
    private String copywriter;
    private String picUrl;
    private int playcount;
    private long createTime;
    private CreatorBean creator;
    private int trackCount;
    private int userId;
    private String alg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCopywriter() {
        return copywriter;
    }

    public void setCopywriter(String copywriter) {
        this.copywriter = copywriter;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public static class CreatorBean {
        /**
         * remarkName : null
         * mutual : false
         * backgroundImgId : 2002210674180202
         * detailDescription : 网易云音乐官方账号
         * defaultAvatar : false
         * expertTags : null
         * djStatus : 10
         * followed : false
         * backgroundUrl : http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg
         * avatarImgId : 1420569024374784
         * backgroundImgIdStr : 2002210674180202
         * accountStatus : 0
         * userId : 1
         * vipType : 11
         * province : 110000
         * avatarUrl : https://p2.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg
         * authStatus : 1
         * userType : 2
         * nickname : 网易云音乐
         * gender : 1
         * birthday : -2209017600000
         * city : 110101
         * avatarImgIdStr : 1420569024374784
         * description : 网易云音乐官方账号
         * signature : 网易云音乐是6亿人都在使用的音乐平台，致力于帮助用户发现音乐惊喜，帮助音乐人实现梦想。客服@云音乐客服 在线时间：9：00 - 24：00，如您在使用过程中遇到任何问题，欢迎私信咨询，我们会尽快回复。如果仍然不能解决您的问题，与活动相关的疑问请私信@云音乐客服
         * authority : 3
         */

        private Object remarkName;
        private boolean mutual;
        private long backgroundImgId;
        private String detailDescription;
        private boolean defaultAvatar;
        private Object expertTags;
        private int djStatus;
        private boolean followed;
        private String backgroundUrl;
        private long avatarImgId;
        private String backgroundImgIdStr;
        private int accountStatus;
        private int userId;
        private int vipType;
        private int province;
        private String avatarUrl;
        private int authStatus;
        private int userType;
        private String nickname;
        private int gender;
        private long birthday;
        private int city;
        private String avatarImgIdStr;
        private String description;
        private String signature;
        private int authority;

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }
    }
}