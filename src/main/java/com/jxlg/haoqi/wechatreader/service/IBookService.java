package com.jxlg.haoqi.wechatreader.service;

import com.jxlg.haoqi.wechatreader.pojo.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBookService {


    Book getBookBasicInfoById(String id);

    Book getSimpleBook(String id);

    List<Book> getBookByName(String bookName);

    Book getBookBasicInfoByBookName(String bookName);

    int addBookBasicInfo(MultipartFile file, String path);

    int addBookBasicInfoSelective(Book book);

    int removeBookBasicInfoById(String id);

    int updateByPrimaryKeySelective(Book book);

    int updateByPrimaryKey(Book book);


}
