package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Bookrack;

import java.util.List;

public interface BookrackMapper {
    int deleteByPrimaryKey(String id);

    int insert(Bookrack record);

    int insertSelective(Bookrack record);

    Bookrack selectByPrimaryKey(String id);

    List<Bookrack> selectByReadId(String readerId);

    int updateByPrimaryKeySelective(Bookrack record);

    int updateByPrimaryKey(Bookrack record);

    Bookrack selectByReadIdAndBookId(Bookrack record);
}