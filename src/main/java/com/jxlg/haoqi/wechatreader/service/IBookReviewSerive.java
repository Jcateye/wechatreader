package com.jxlg.haoqi.wechatreader.service;

import com.github.pagehelper.PageInfo;
import com.jxlg.haoqi.wechatreader.pojo.BookReview;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewResponseVO;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewUserVO;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewVO;
import org.springframework.web.multipart.MultipartFile;

public interface IBookReviewSerive {

    public PageInfo<ReviewUserVO> getBookReviewPage(ReviewVO ReviewVO);

    ReviewResponseVO getReviewDetail(String id);

    PageInfo<ReviewResponseVO> getSonBookReviewPage(ReviewVO reviewVO);

    PageInfo<ReviewResponseVO> getReview(ReviewVO reviewVo);

    int addBookReview(BookReview bookReview);

    int removeBookReview(String id);

    void insert1(MultipartFile file, String bookId, String readerId,String parentId);
}
