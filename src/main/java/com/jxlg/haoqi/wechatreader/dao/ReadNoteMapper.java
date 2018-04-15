package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.ReadNote;

public interface ReadNoteMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReadNote record);

    int insertSelective(ReadNote record);

    ReadNote selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReadNote record);

    int updateByPrimaryKey(ReadNote record);
}