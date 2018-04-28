package com.jxlg.haoqi.wechatreader;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.jxlg.haoqi.wechatreader.dao")
public class WechatreaderApplication {

    private final static Logger logger = LoggerFactory.getLogger(WechatreaderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WechatreaderApplication.class, args);
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
    }
}
