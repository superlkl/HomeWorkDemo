package com.example.mythirddemo.my;

import java.util.List;

public class CheckStatus {

    /**
     * code : 200
     * profile : {"userId":544517175,"nickname":"super乾能","avatarUrl":"http://p4.music.126.net/OBE8nmItMepIM_CVsZwj0A==/109951163381987369.jpg","birthday":"-2209017600000","userType":0,"djStatus":0}
     * bindings : [{"expiresIn":2147483647,"expired":false,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"183****9119\",\"hasPassword\":true}","refreshTime":1500366103,"id":3179280339,"type":1,"bindingTime":1500366103049,"userId":544517175,"url":""}]
     */

    private int code;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class ProfileBean {
        /**
         * userId : 544517175
         * nickname : super乾能
         * avatarUrl : http://p4.music.126.net/OBE8nmItMepIM_CVsZwj0A==/109951163381987369.jpg
         * birthday : -2209017600000
         * userType : 0
         * djStatus : 0
         */

        private int userId;
        private String nickname;
        private String avatarUrl;
        private String birthday;
        private int userType;
        private int djStatus;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }
    }

    public static class BindingsBean {
        /**
         * expiresIn : 2147483647
         * expired : false
         * tokenJsonStr : {"countrycode":"","cellphone":"183****9119","hasPassword":true}
         * refreshTime : 1500366103
         * id : 3179280339
         * type : 1
         * bindingTime : 1500366103049
         * userId : 544517175
         * url :
         */

        private int expiresIn;
        private boolean expired;
        private String tokenJsonStr;
        private int refreshTime;
        private long id;
        private int type;
        private long bindingTime;
        private int userId;
        private String url;

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
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

        public long getBindingTime() {
            return bindingTime;
        }

        public void setBindingTime(long bindingTime) {
            this.bindingTime = bindingTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
