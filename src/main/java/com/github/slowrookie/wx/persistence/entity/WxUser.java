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
}
