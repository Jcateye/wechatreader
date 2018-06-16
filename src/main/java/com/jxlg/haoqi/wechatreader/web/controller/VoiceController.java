package com.jxlg.haoqi.wechatreader.web.controller;

import com.jxlg.haoqi.wechatreader.pojo.Chapter;
import com.jxlg.haoqi.wechatreader.pojo.Response;
import com.jxlg.haoqi.wechatreader.service.IVoiceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class VoiceController {

    @Autowired
    private IVoiceService voiceService;

    @RequestMapping("/voice")
    public Response getVoiceAction(@RequestParam("voice") MultipartFile file ,@RequestParam("readerId") String readerId) {
            Response resp = new Response();
            try {
                Chapter voiceString = voiceService.getVoiceString(file, readerId);
                if(voiceString == null) {
                    resp.setCode(500);
                    resp.setData(null);
                    resp.setMessage("指令不完整");
                    return resp;
                }
                resp.setData(voiceString);
                return resp;
            }catch (Exception e) {
                resp.setCode(500);
                resp.setMessage("error");
            }
            return null;
        }

}
