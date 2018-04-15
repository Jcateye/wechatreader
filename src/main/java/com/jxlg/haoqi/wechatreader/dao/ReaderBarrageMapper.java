package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.ReaderBarrage;

public interface ReaderBarrageMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReaderBarrage record);

    int insertSelective(ReaderBarrage record);

    ReaderBarrage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReaderBarrage record);

    int updateByPrimaryKey(ReaderBarrage record);
}