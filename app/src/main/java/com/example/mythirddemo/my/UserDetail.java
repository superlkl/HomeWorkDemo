package com.example.mythirddemo.my;

import java.util.List;

public class UserDetail {

    /**
     * level : 7
     * listenSongs : 2496
     * userPoint : {"userId":544517175,"balance":161,"updateTime":1566574692221,"version":10,"status":0,"blockBalance":0}
     * mobileSign : false
     * pcSign : false
     * profile : {"accountStatus":0,"djStatus":0,"province":520000,"vipType":0,"followed":false,"avatarImgId":109951163381987380,"birthday":-2209017600000,"gender":0,"nickname":"super乾能","description":"","userId":544517175,"userType":0,"avatarUrl":"http://p1.music.126.net/OBE8nmItMepIM_CVsZwj0A==/109951163381987369.jpg","backgroundUrl":"http://p1.music.126.net/pKMW4NE7xATa6TZnQ-JcjA==/109951163432667529.jpg","city":520100,"defaultAvatar":false,"mutual":false,"remarkName":null,"authStatus":0,"detailDescription":"","experts":{},"expertTags":null,"backgroundImgId":109951163432667540,"avatarImgIdStr":"109951163381987369","backgroundImgIdStr":"109951163432667529","signature":"","authority":0,"followeds":1,"follows":31,"blacklist":false,"eventCount":0,"allSubscribedCount":0,"playlistBeSubscribedCount":0,"avatarImgId_str":"109951163381987369","followTime":null,"artistIdentity":[],"cCount":0,"sDJPCount":0,"playlistCount":2,"sCount":0,"newFollows":33}
     * peopleCanSeeMyPlayRecord : false
     * bindings : [{"url":"","userId":544517175,"expiresIn":2147483647,"refreshTime":1500366103,"bindingTime":1500366103049,"tokenJsonStr":null,"expired":false,"id":3179280339,"type":1}]
     * adValid : true
     * code : 200
     * createTime : 1500366103047
     * createDays : 767
     */

    private int level;
    private int listenSongs;
    private UserPointBean userPoint;
    private boolean mobileSign;
    private boolean pcSign;
    private ProfileBean profile;
    private boolean peopleCanSeeMyPlayRecord;
    private boolean adValid;
    private int code;
    private long createTime;
    private int createDays;
    private List<BindingsBean> bindings;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getListenSongs() {
        return listenSongs;
    }

    public void setListenSongs(int listenSongs) {
        this.listenSongs = listenSongs;
    }

    public UserPointBean getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(UserPointBean userPoint) {
        this.userPoint = userPoint;
    }

    public boolean isMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(boolean mobileSign) {
        this.mobileSign = mobileSign;
    }

    public boolean isPcSign() {
        return pcSign;
    }

    public void setPcSign(boolean pcSign) {
        this.pcSign = pcSign;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public boolean isPeopleCanSeeMyPlayRecord() {
        return peopleCanSeeMyPlayRecord;
    }

    public void setPeopleCanSeeMyPlayRecord(boolean peopleCanSeeMyPlayRecord) {
        this.peopleCanSeeMyPlayRecord = peopleCanSeeMyPlayRecord;
    }

    public boolean isAdValid() {
        return adValid;
    }

    public void setAdValid(boolean adValid) {
        this.adValid = adValid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getCreateDays() {
        return createDays;
    }

    public void setCreateDays(int createDays) {
        this.createDays = createDays;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class UserPointBean {
        /**
         * userId : 544517175
         * balance : 161
         * updateTime : 1566574692221
         * version : 10
         * status : 0
         * blockBalance : 0
         */

        private int userId;
        private int balance;
        private long updateTime;
        private int version;
        private int status;
        private int blockBalance;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getBlockBalance() {
            return blockBalance;
        }

        public void setBlockBalance(int blockBalance) {
            this.blockBalance = blockBalance;
        }
    }

    public static class ProfileBean {
        /**
         * accountStatus : 0
         * djStatus : 0
         * province : 520000
         * vipType : 0
         * followed : false
         * avatarImgId : 109951163381987380
         * birthday : -2209017600000
         * gender : 0
         * nickname : super乾能
         * description :
         * userId : 544517175
         * userType : 0
         * avatarUrl : http://p1.music.126.net/OBE8nmItMepIM_CVsZwj0A==/109951163381987369.jpg
         * backgroundUrl : http://p1.music.126.net/pKMW4NE7xATa6TZnQ-JcjA==/109951163432667529.jpg
         * city : 520100
         * defaultAvatar : false
         * mutual : false
         * remarkName : null
         * authStatus : 0
         * detailDescription :
         * experts : {}
         * expertTags : null
         * backgroundImgId : 109951163432667540
         * avatarImgIdStr : 109951163381987369
         * backgroundImgIdStr : 109951163432667529
         * signature :
         * authority : 0
         * followeds : 1
         * follows : 31
         * blacklist : false
         * eventCount : 0
         * allSubscribedCount : 0
         * playlistBeSubscribedCount : 0
         * avatarImgId_str : 109951163381987369
         * followTime : null
         * artistIdentity : []
         * cCount : 0
         * sDJPCount : 0
         * playlistCount : 2
         * sCount : 0
         * newFollows : 33
         */

        private int accountStatus;
        private int djStatus;
        private int province;
        private int vipType;
        private boolean followed;
        private long avatarImgId;
        private long birthday;
        private int gender;
        private String nickname;
        private String description;
        private int userId;
        private int userType;
        private String avatarUrl;
        private String backgroundUrl;
        private int city;
        private boolean defaultAvatar;
        private boolean mutual;
        private Object remarkName;
        private int authStatus;
        private String detailDescription;
        private ExpertsBean experts;
        private Object expertTags;
        private long backgroundImgId;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String signature;
        private int authority;
        private int followeds;
        private int follows;
        private boolean blacklist;
        private int eventCount;
        private int allSubscribedCount;
        private int playlistBeSubscribedCount;
        private String avatarImgId_str;
        private Object followTime;
        private int cCount;
        private int sDJPCount;
        private int playlistCount;
        private int sCount;
        private int newFollows;
        private List<?> artistIdentity;

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
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

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public boolean isBlacklist() {
            return blacklist;
        }

        public void setBlacklist(boolean blacklist) {
            this.blacklist = blacklist;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getAllSubscribedCount() {
            return allSubscribedCount;
        }

        public void setAllSubscribedCount(int allSubscribedCount) {
            this.allSubscribedCount = allSubscribedCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public String getAvatarImgId_str() {
            return avatarImgId_str;
        }

        public void setAvatarImgId_str(String avatarImgId_str) {
            this.avatarImgId_str = avatarImgId_str;
        }

        public Object getFollowTime() {
            return followTime;
        }

        public void setFollowTime(Object followTime) {
            this.followTime = followTime;
        }

        public int getCCount() {
            return cCount;
        }

        public void setCCount(int cCount) {
            this.cCount = cCount;
        }

        public int getSDJPCount() {
            return sDJPCount;
        }

        public void setSDJPCount(int sDJPCount) {
            this.sDJPCount = sDJPCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getSCount() {
            return sCount;
        }

        public void setSCount(int sCount) {
            this.sCount = sCount;
        }

        public int getNewFollows() {
            return newFollows;
        }

        public void setNewFollows(int newFollows) {
            this.newFollows = newFollows;
        }

        public List<?> getArtistIdentity() {
            return artistIdentity;
        }

        public void setArtistIdentity(List<?> artistIdentity) {
            this.artistIdentity = artistIdentity;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * url :
         * userId : 544517175
         * expiresIn : 2147483647
         * refreshTime : 1500366103
         * bindingTime : 1500366103049
         * tokenJsonStr : null
         * expired : false
         * id : 3179280339
         * type : 1
         */

        private String url;
        private int userId;
        private int expiresIn;
        private int refreshTime;
        private long bindingTime;
        private Object tokenJsonStr;
        private boolean expired;
        private long id;
        private int type;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public Object getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(Object tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

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
    }
}
