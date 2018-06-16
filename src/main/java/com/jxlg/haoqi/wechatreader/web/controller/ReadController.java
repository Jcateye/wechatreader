package com.jxlg.haoqi.wechatreader.web.controller;

import com.jxlg.haoqi.wechatreader.pojo.Chapter;
import com.jxlg.haoqi.wechatreader.pojo.Response;
import com.jxlg.haoqi.wechatreader.service.IChapterService;
import com.jxlg.haoqi.wechatreader.web.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
public class ReadController {

    @Autowired
    private IChapterService chapterService;


    @RequestMapping(value = "/start", produces = "application/json;charset=utf-8")
    public Response readStart(ReviewVO reviewVO) {
        Response resp = new Response();
        try {
            Chapter chapter = chapterService.getChapter(reviewVO);
            resp.setData(chapter);
        }catch (Exception e) {
            resp.setCode(500);
            resp.setMessage(e.getMessage());
        }
        return resp;
    }
}
