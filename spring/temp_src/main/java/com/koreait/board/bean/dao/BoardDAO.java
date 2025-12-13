package com.koreait.board.bean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.board.bean.vo.BoardVO;
import com.koreait.board.bean.vo.Criteria;
import com.koreait.board.mapper.BoardMapper;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper mapper;
	
	// register(insert)
	public int register(BoardVO board) {
		//return mapper.insert(board);
		return mapper.insertSelectKey(board);
	}
	
	// getList
	public List<BoardVO> getList(){
		return mapper.getList();
	}
	
	// getList
	public List<BoardVO> getListWithKey(String type, String keyword){
		return mapper.getListWithKey(type, keyword);
	}
	
	public List<BoardVO> getListWithPaging(Criteria cri){
		cri.setOffset();
		return mapper.getListWithPaging(cri);
	}
	
	// remove(delete)
	public int remove(Long bno) {
		return mapper.delete(bno);
	}
	
	// modify(update)
	public int modify(BoardVO vo) {
		return mapper.update(vo);
	}
	
	// read(get)
	public BoardVO read(Long bno) {
		return mapper.get(bno);
	}
	
}
