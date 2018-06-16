package com.jxlg.haoqi.wechatreader.service;

import com.github.pagehelper.PageInfo;
import com.jxlg.haoqi.wechatreader.pojo.Book;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewVO;

public interface IBookrackService {

    PageInfo<Book> getBooks(ReviewVO reviewVO);

    int addBookrack(ReviewVO reviewVO);
}
