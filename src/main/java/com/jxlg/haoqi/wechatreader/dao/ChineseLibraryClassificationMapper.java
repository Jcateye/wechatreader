package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.ChineseLibraryClassification;

public interface ChineseLibraryClassificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(ChineseLibraryClassification record);

    int insertSelective(ChineseLibraryClassification record);

    ChineseLibraryClassification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ChineseLibraryClassification record);

    int updateByPrimaryKey(ChineseLibraryClassification record);
}