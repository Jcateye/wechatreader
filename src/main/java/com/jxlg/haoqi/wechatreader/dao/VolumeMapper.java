package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Volume;

public interface VolumeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Volume record);

    int insertSelective(Volume record);

    Volume selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Volume record);

    int updateByPrimaryKey(Volume record);
}