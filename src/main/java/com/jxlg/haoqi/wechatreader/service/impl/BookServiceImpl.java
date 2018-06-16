package com.jxlg.haoqi.wechatreader.service.impl;

import com.github.pagehelper.PageHelper;
import com.jxlg.haoqi.wechatreader.Utils.UuidUtil;
import com.jxlg.haoqi.wechatreader.dao.BookMapper;
import com.jxlg.haoqi.wechatreader.pojo.Book;
import com.jxlg.haoqi.wechatreader.service.IBookService;
import com.jxlg.haoqi.wechatreader.service.IChapterService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl  implements IBookService{

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private IChapterService chapterService;

    private Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book getBookBasicInfoById(String id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public Book getSimpleBook(String id) {
        return bookMapper.selectSimpleByPrimaryKey(id);
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        return bookMapper.selectByBookName(bookName);
    }

    @Override
    public Book getBookBasicInfoByBookName(String bookName) {
        return null;
    }



    @Override
    public int addBookBasicInfo(MultipartFile file, String path)  {
        Book book = new Book();
        int insert =0;
        String fileName = file.getOriginalFilename();
        int j = fileName.lastIndexOf(".");
        String bookName = fileName.substring(0,j);
        book.setId(UuidUtil.getUUid32());
        book.setBookName(bookName);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            InputStreamReader ir = new InputStreamReader(inputStream, "GB2312");
            char[] chars = new char[1024];
            StringBuffer sb = new StringBuffer();
            int read = ir.read(chars);
            sb.append(chars);
            book.setIntro(sb.toString());
            insert = bookMapper.insert(book);
            log.info("新增书籍:"+ bookName);

            //插入章节
           if(read != -1) {
               int sequence = 1;
               ir.read(chars);
               sb.append(chars);
               chapterService.addChapter(sb.toString(),book.getId(),sequence);

               char[] c = new char[2048];
               while(ir.read(c) != -1) {
                   sb = new StringBuffer();
                   sequence++;
                   sb.append(c);
                   chapterService.addChapter(sb.toString(),book.getId(),sequence);
               }
           }else{
               log.warn("书籍无章节: "+ bookName);
               return -1;
           }

        } catch (IOException e) {
            log.warn("新增书籍失败:"+ bookName);
        }

        return insert;
    }

    @Override
    public int addBookBasicInfoSelective(Book book) {

        return bookMapper.insertSelective(book);
    }

    @Override
    public int removeBookBasicInfoById(String id) {

        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public int updateByPrimaryKey(Book book) {
        return updateByPrimaryKey(book);
    }
}
