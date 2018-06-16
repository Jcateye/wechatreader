package com.jxlg.haoqi.wechatreader.service;

import com.jxlg.haoqi.wechatreader.pojo.Chapter;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewVO;

public interface IChapterService {

    int addChapter(String content,String bookId, Integer integer);

    Chapter getChapter(ReviewVO reviewVO) throws Exception;
}
