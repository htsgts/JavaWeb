package com.koreait.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.board.bean.vo.AttachFileVO;

@Mapper
public interface AttachFileMapper {
	
	public int insert(AttachFileVO vo);
	public List<AttachFileVO> findByBno(Long bno);
	
}
