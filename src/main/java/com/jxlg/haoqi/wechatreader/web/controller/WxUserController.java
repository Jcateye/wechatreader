package com.jxlg.haoqi.wechatreader.web.controller;

import com.jxlg.haoqi.wechatreader.pojo.Response;
import com.jxlg.haoqi.wechatreader.pojo.WxUser;
import com.jxlg.haoqi.wechatreader.pojo.WxUserCheckout;
import com.jxlg.haoqi.wechatreader.service.IWxUserService;
import com.jxlg.haoqi.wechatreader.web.vo.UserInfoVO;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/wxuser")
public class WxUserController {

    @Autowired
    private IWxUserService wxUserService;

    @RequestMapping("/checkout")
    public Response checkoutWxuser(@RequestBody UserInfoVO userInfoVO) {

        Response resp = new Response();
        try {
            WxUser wxUser = wxUserService.checkWxUser(userInfoVO);
            resp.setData(wxUser);
        }catch (Exception e) {
            resp.setCode(500);
            resp.setMessage("error");
        }
        return resp;
    }
}
