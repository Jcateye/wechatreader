package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.ReadLog;

public interface ReadLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReadLog record);

    int insertSelective(ReadLog record);

    ReadLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReadLog record);

    int updateByPrimaryKey(ReadLog record);
}