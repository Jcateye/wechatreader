package com.jxlg.haoqi.wechatreader.web.vo;

import com.jxlg.haoqi.wechatreader.pojo.BookReview;
import com.jxlg.haoqi.wechatreader.pojo.WxUser;

public class ReviewUserVO extends BookReview {
    private WxUser user;

    public WxUser getUser() {
        return user;
    }

    public void setUser(WxUser user) {
        this.user = user;
    }
}
