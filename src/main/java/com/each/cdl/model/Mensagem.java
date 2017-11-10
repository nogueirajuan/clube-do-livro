package com.each.cdl.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Mensagem {
    private String sender;
    private String receiver;
    private String content;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date sendDate;

    public Mensagem(String sender, String receiver, String content, Date sendDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sendDate = sendDate;
    }

    public Mensagem() {}
}
