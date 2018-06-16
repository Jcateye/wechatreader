package com.jxlg.haoqi.wechatreader.dao;

import com.jxlg.haoqi.wechatreader.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    List<Book> selectByBookName(@Param("bookName") String bookName);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    Book selectSimpleByPrimaryKey(String id);
}