package com.jxlg.haoqi.wechatreader.service;

import com.jxlg.haoqi.wechatreader.pojo.ItemTotal;

import java.util.List;

public interface IUpdateFocus {

    void update(List<ItemTotal> itemTotals, String itemFlag);

    void insert(  List<ItemTotal> itemTotals);
    void start();
}
