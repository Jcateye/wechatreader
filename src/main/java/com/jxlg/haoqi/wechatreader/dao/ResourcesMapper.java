package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Resources;

public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    int insertSelective(Resources record);

    Resources selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}