package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.BookReview;

import java.util.List;

public interface BookReviewMapper {
    int deleteByPrimaryKey(String id);

    int insert(BookReview record);

    int insertSelective(BookReview record);

    BookReview selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BookReview record);

    int updateByPrimaryKeyWithBLOBs(BookReview record);

    int updateByPrimaryKey(BookReview record);

    List<BookReview> selectiveBy2Id(BookReview bookReview);

    List<BookReview> selectByParentId(String parentId);

    int deleteByParentId(String parentId);
}