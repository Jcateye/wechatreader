package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Bookrack;

public interface BookrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(Bookrack record);

    int insertSelective(Bookrack record);

    Bookrack selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Bookrack record);

    int updateByPrimaryKey(Bookrack record);
}