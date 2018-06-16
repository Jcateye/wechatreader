package com.jxlg.haoqi.wechatreader.service.impl;

import com.baidu.aip.speech.AipSpeech;
import com.jxlg.haoqi.wechatreader.dao.BookMapper;
import com.jxlg.haoqi.wechatreader.dao.BookrackMapper;
import com.jxlg.haoqi.wechatreader.dao.ChapterMapper;
import com.jxlg.haoqi.wechatreader.pojo.*;
import com.jxlg.haoqi.wechatreader.service.IVoiceService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VoiceServiceImpl implements IVoiceService {
    @Autowired
    private BookrackMapper bookrackMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ChapterMapper chapterMapper;

    public Chapter getVoiceString(MultipartFile file, String readerId) throws IOException {
        AipSpeech client = new AipSpeech(ConstantUser.BAIDU_APP_ID, ConstantUser.BAIDU_API_KEY, ConstantUser.BAIDU_SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        byte[] bytes = file.getBytes();
        JSONObject res = client.asr(bytes, "wav", 16000, null);
        System.out.println(res.toString(2));
        return getVoiceBookId(readerId, getAction(res));
    }

    public String getAction(JSONObject json) {
        if (json.getInt("err_no") == 0) {
            String result = json.getString("result");
            result = result.replaceAll(",", "");
            for (String command : VoiceCommand.START_ACTION) {
                if (result.contains(command)) {
                    int i = result.indexOf(command);
                    result = result.substring(i + command.length() - 1);
                    break;
                }
            }
            return result;
        }
        return null;
    }

    public Chapter getVoiceBookId(String readId, String bookName) {
        if (StringUtils.isNotEmpty(bookName)) {
            List<Bookrack> bookracks = bookrackMapper.selectByReadId(readId);
            for (Bookrack bookrack : bookracks) {
                Book book = bookMapper.selectSimpleByPrimaryKey(bookrack.getBookId());
                if (StringUtils.equals(bookName, book.getBookName())) {
                    Chapter chapter = new Chapter();
                    chapter.setBookId(book.getId());
                    chapter.setSequence(1);
                    return chapterMapper.selectByBookIdAndSequ(chapter);
                }
            }
            return null;
        }
        return null;
    }
}
