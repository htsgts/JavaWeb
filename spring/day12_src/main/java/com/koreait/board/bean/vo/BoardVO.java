package com.koreait.board.bean.vo;

import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updatedate;
	private List<AttachFileVO> attachFile;
	// input tag의 name에
	// attachFile[i].fileName
	// attachFile[i].uuid
	// attachFile[i].uploadPath
	// attachFile[i].image
	// 방식으로 submit하면 자동으로 List에 매핑된다.
	
//	public Long getBno() {
//		log.info("getBno() Called");
//		return 10001L;
//	}
	
	public Long getRealBno() {
		return bno;
	}
}
