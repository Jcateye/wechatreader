package com.jxlg.haoqi.wechatreader.service;

import com.jxlg.haoqi.wechatreader.pojo.Chapter;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IVoiceService {
    Chapter getVoiceString(MultipartFile file, String readerId) throws IOException;
}
