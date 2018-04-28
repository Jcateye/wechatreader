package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.RoleResources;

public interface RoleResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResources record);

    int insertSelective(RoleResources record);

    RoleResources selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResources record);

    int updateByPrimaryKey(RoleResources record);
}