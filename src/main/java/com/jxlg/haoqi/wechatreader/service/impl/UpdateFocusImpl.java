package com.jxlg.haoqi.wechatreader.service.impl;

import com.jxlg.haoqi.wechatreader.Utils.UuidUtil;
import com.jxlg.haoqi.wechatreader.dao.BookFocusMapper;
import com.jxlg.haoqi.wechatreader.pojo.BookFocus;
import com.jxlg.haoqi.wechatreader.pojo.ItemTotal;
import com.jxlg.haoqi.wechatreader.service.IUpdateFocus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UpdateFocusImpl implements IUpdateFocus{

    @Autowired
    private BookFocusMapper bookFocusMapper;

    public  void update(List<ItemTotal> itemTotals, String itemFlag) {
        for(ItemTotal item: itemTotals) {
            String bookId = item.getBookId();
            BookFocus bookFocus = new BookFocus();
            bookFocus.setBookId(bookId);
            bookFocus.setUpdateTime(new Date());

            switch (itemFlag){
                 case("review"):
                     bookFocus.setReviewTotal(item.getTotal());
                     break;
                case("reader"):
                    bookFocus.setReaderTotal(item.getTotal());
                    break;
                case("note"):
                    bookFocus.setNoteTotal(item.getTotal());
                    break;
                case("search"):
                    bookFocus.setSearchTotal(item.getTotal());
                    break;
            }
            bookFocusMapper.updateByBookIdSelective(bookFocus);
        }
    }

    public void insert(  List<ItemTotal> itemTotals) {
        for(ItemTotal item: itemTotals) {
            String bookId = item.getBookId();
            List<BookFocus> bookFoci = bookFocusMapper.selectByBookId(bookId);
            if(bookFoci.size()==0) {
                BookFocus bookFocus = new BookFocus();
                bookFocus.setId(UuidUtil.getUUid32());
                bookFocus.setCreateTime(new Date());
                bookFocus.setBookId(bookId);
                bookFocusMapper.insertSelective(bookFocus);
            }
        }

    }

    public void start() {
        List<ItemTotal> reviewTotal = bookFocusMapper.reviewTotal();
        if(reviewTotal.size()>0) {
            insert(reviewTotal);
            update(reviewTotal, "review");
        }

        List<ItemTotal> readerTotal = bookFocusMapper.readerTotal();
        if(readerTotal.size()>0) {
            insert(readerTotal);
            update(readerTotal, "reader");
        }

        List<ItemTotal> noteTotal = bookFocusMapper.noteTotal();
        if(noteTotal.size()>0) {
            insert(noteTotal);
            update(noteTotal, "note");
        }



    }
}
