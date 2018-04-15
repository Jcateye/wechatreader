package com.jxlg.haoqi.wechatreader.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookReview implements Serializable {
    private String id;

    private String bookId;

    private String readerId;

    private Date createTime;

    private Date updareTime;

    private String details;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId == null ? null : readerId.trim();
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}