package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.BookReviewInteraction;

public interface BookReviewInteractionMapper {
    int deleteByPrimaryKey(String id);

    int insert(BookReviewInteraction record);

    int insertSelective(BookReviewInteraction record);

    BookReviewInteraction selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BookReviewInteraction record);

    int updateByPrimaryKey(BookReviewInteraction record);
}