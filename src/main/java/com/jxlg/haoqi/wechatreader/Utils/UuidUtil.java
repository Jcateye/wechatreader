package com.jxlg.haoqi.wechatreader.Utils;

import java.util.UUID;

public class UuidUtil {

    public static String getUUid32() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-","");
    }
}
