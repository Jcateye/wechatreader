package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Book;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}