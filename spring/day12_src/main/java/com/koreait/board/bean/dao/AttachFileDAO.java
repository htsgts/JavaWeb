package com.koreait.board.bean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.board.bean.vo.AttachFileVO;
import com.koreait.board.mapper.AttachFileMapper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AttachFileDAO {
	@Autowired
	AttachFileMapper mapper;
	
	public int insert(AttachFileVO vo) {
		return mapper.insert(vo);
	}
	
	public List<AttachFileVO> findByBno(Long bno){
		return mapper.findByBno(bno);
	}
}
