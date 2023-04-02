package com.sunwo.board.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDTO {
    private long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedTime;
}
