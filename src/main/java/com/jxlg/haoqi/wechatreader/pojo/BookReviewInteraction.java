package com.jxlg.haoqi.wechatreader.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookReviewInteraction implements Serializable {
    private String id;

    private String brId;

    private String readerId;

    private Byte support;

    private Byte transpond;

    private Date createTime;

    private Date updareTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBrId() {
        return brId;
    }

    public void setBrId(String brId) {
        this.brId = brId == null ? null : brId.trim();
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
    }

    public Byte getSupport() {
        return support;
    }

    public void setSupport(Byte support) {
        this.support = support;
    }

    public Byte getTranspond() {
        return transpond;
    }

    public void setTranspond(Byte transpond) {
        this.transpond = transpond;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdareTime() {
        return updareTime;
    }

    public void setUpdareTime(Date updareTime) {
        this.updareTime = updareTime;
    }
}