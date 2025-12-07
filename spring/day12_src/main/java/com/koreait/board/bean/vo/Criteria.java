package com.koreait.board.bean.vo;

import lombok.Data;

@Data
public class Criteria {  // 페이지 검색 기준
	private int pageNum;  // 지금 보고 있는 페이지가 몇 페이지인가?
	private int amount;  // 한 페이지에 들어갈 게시글 수
	private int offset;  // 현재 페이지의 기준이 되는 글 누적 개수
	// limit 10 offset 20  => 21번부터 30번째까지의 결과 데이터 리턴
	
	// 검색어
	private String type;
	private String keyword;
	
	public Criteria() {
		pageNum = 1;
		amount = 10;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public void setOffset() {
		offset = (pageNum - 1) * amount;
		// limit #{amount} offset #{offset}
	}
}
