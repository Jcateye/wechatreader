package com.jxlg.haoqi.wechatreader.service.impl;

import com.jxlg.haoqi.wechatreader.dao.ReadNoteMapper;
import com.jxlg.haoqi.wechatreader.pojo.ReadNote;
import com.jxlg.haoqi.wechatreader.service.IReadNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadNoteService implements IReadNoteService {
    @Autowired
    private ReadNoteMapper readNoteMapper;

    @Override
    public int addNote(ReadNote readNote) {
        return readNoteMapper.insert(readNote);
    }
}
