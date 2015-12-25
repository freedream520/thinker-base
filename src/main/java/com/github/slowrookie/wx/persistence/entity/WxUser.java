package com.github.slowrookie.wx.persistence.entity;

import com.github.slowrookie.persistence.AuditablePersistable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WeiXin User
 * Created by liujx on 15-12-25.
 */
@Entity
@Table(name = "wx_user")
public class WxUser extends AuditablePersistable{

    @Column(name = "subscribe_")
    protected Boolean subscribe;

    @Column(name = "openId_")
    protected String openId;

    @Column(name = "nickname_")
    protected String nickname;

    @Column(name = "sex_")
    protected String sex;

    @Column(name = "language_")
    protected String language;

    @Column(name = "city_")
    protected String city;

    @Column(name = "province_")
    protected String province;

    @Column(name = "country_")
    protected String country;

    @Column(name = "headImgUrl_")
    protected String headImgUrl;

    @Column(name = "subscribeTime_")
    protected Long subscribeTime;

    @Column(name = "unionId_")
    protected String unionId;

    @Column(name = "sexId_")
    protected Integer sexId;

    @Column(name = "remark_")
    protected String remark;

    @Column(name = "groupId_")
    protected Integer groupId;

    public WxUser() {
    }

    public WxUser(Long id) {
        super(id);
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "subscribe=" + subscribe +
                ", openId='" + openId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", subscribeTime=" + subscribeTime +
                ", unionId='" + unionId + '\'' +
                ", sexId=" + sexId +
                ", remark='" + remark + '\'' +
                ", groupId=" + groupId +
                "} " + super.toString();
    }
}
