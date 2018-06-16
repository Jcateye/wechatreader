package com.jxlg.haoqi.wechatreader.service.impl;

import com.jxlg.haoqi.wechatreader.Utils.UuidUtil;
import com.jxlg.haoqi.wechatreader.dao.BookrackMapper;
import com.jxlg.haoqi.wechatreader.dao.ChapterMapper;
import com.jxlg.haoqi.wechatreader.pojo.Bookrack;
import com.jxlg.haoqi.wechatreader.pojo.Chapter;
import com.jxlg.haoqi.wechatreader.service.IChapterService;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChapterServiceImpl implements IChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private BookrackMapper bookrackMapper;

    @Override
    public int addChapter(String content,String bookId, Integer integer) {
        Chapter chapter = new Chapter();
        chapter.setId(UuidUtil.getUUid32());
        chapter.setBookId(bookId);
        chapter.setChapterTitle(content.substring(0,3));
        chapter.setContent(content);
        chapter.setSequence(integer);
        Date date = new Date();
        chapter.setCreateTime(date);
        chapter.setUpdateTime(date);
        return chapterMapper.insert(chapter) ;
    }

    @Override
    public Chapter getChapter(ReviewVO reviewVO) throws Exception {
        Bookrack bookrack = new Bookrack();
        bookrack.setBookId(reviewVO.getBookId());
        bookrack.setReaderId(reviewVO.getReaderId());
         bookrack = bookrackMapper.selectByReadIdAndBookId(bookrack);
        if(bookrack == null) {
            throw new Exception("查无此书");
        }
        Double readingState = bookrack.getReadingState();
        if(readingState == null || readingState <= 0.0) {
            readingState = new Double(1.00);
        }
        Chapter chapter = new Chapter();
        chapter.setBookId(reviewVO.getBookId());

        if(reviewVO.getPageNo()== -9 ){
            chapter.setSequence(readingState.intValue());
        }else{
            chapter.setSequence(reviewVO.getPageNo());
        }
        chapter = chapterMapper.selectByBookIdAndSequ(chapter);

        return chapter;
    }
}
