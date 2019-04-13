package com.ocean.pojo;

import java.util.Date;

public class Active {
    private Integer id;

    private String title;

    private Float rate;

    private String tag;

    private String image;

    private String details;

    private Integer type;

    private Date beginningTime;

    private Date endingTime;

    private String telphone;

    private Integer limitOfAge;

    private Integer rangOfPeople;

    private String location;

    private String address;

    private Integer auth;

    private Integer status;

    private Date createTime;

    private Integer publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getBeginningTime() {
        return beginningTime;
    }

    public void setBeginningTime(Date beginningTime) {
        this.beginningTime = beginningTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public Integer getLimitOfAge() {
        return limitOfAge;
    }

    public void setLimitOfAge(Integer limitOfAge) {
        this.limitOfAge = limitOfAge;
    }

    public Integer getRangOfPeople() {
        return rangOfPeople;
    }

    public void setRangOfPeople(Integer rangOfPeople) {
        this.rangOfPeople = rangOfPeople;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }
}