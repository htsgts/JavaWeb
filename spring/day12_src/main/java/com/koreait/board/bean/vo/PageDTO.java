package com.koreait.board.bean.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PageDTO {
	private int startPage;  // 현재 View에서의 첫 페이지(ex 31)
	private int endPage;	// 현재 View에서의 마지막 페이지(ex 40)
	private int realEndPage;  // 정말 마지막 페이지(ex 34)
	private boolean prev, next;
	
	private Criteria criteria;  // 페이지 내부와 검색 기준
	private int total;
	
	public PageDTO(Criteria cri, int total) {
		this.criteria = cri;
		this.total = total;
		
		endPage = (int)(Math.ceil(cri.getPageNum() / 10.0) * 10 );
		startPage = endPage - 9;
		
		realEndPage = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		if(realEndPage < endPage) {
			endPage = (realEndPage==0)? 1 : realEndPage;
		}
		
		prev = startPage > 1;
		next = endPage < realEndPage;
	}
}
