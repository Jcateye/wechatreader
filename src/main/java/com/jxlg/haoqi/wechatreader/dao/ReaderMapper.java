package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Reader;

public interface ReaderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}