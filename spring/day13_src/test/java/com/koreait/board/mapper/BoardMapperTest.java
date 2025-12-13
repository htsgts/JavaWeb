package com.koreait.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.koreait.board.bean.vo.BoardVO;
import com.koreait.board.bean.vo.TestVO;
import com.koreait.board.util.MyUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("나도 축구 봄 눈 썩음");
		vo.setContent("경기 내용이 수준 이하");
		vo.setWriter("경기본자");
		
		mapper.insert(vo);
		log.info("BoardVO : " + vo);
		
		TestVO vo2 = new TestVO();
		mapper.insert2(vo2);
		
		mapper.insertSelectKey(vo);
		log.info("BoardVO : " + vo);
		log.info("BoardVO : " + vo.getRealBno());
		
		// 임의의 글 50개 인서트를 해보세요.
		for(int i=0; i<100; i++) {
			BoardVO board = new BoardVO();
			board.setTitle("제목" + i);
			board.setContent("내용" + i);
			board.setWriter("글쓴이" + i);
			mapper.insertSelectKey(board);
		}
	}
	
	@Test
	public void testGetList() {
		mapper.getList()
		      .forEach(board->log.info("Board : " + board));
	}
	
	@Test
	public void testDelete() {
		Long bno = 3L;
		
		int result = mapper.delete(bno);
		if(result > 0) {
			log.info(MyUtil.getColor() + bno + "번 글 삭제 성공" + MyUtil.END);
		}
		else {
			log.info(MyUtil.getColor() + "헛스윙" + MyUtil.END);
		}
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(4L);
		vo.setTitle("애런 저지의 25년 성적");
		vo.setContent("타율: .331 \r\n"
				+ "StatMuse\r\n"
				+ "+2\r\n"
				+ "ESPN.com\r\n"
				+ "+2\r\n"
				+ "\r\n"
				+ "출루율(OBP): .457 \r\n"
				+ "StatMuse\r\n"
				+ "+1\r\n"
				+ "\r\n"
				+ "장타율(SLG): .688 \r\n"
				+ "StatMuse\r\n"
				+ "+1\r\n"
				+ "\r\n"
				+ "OPS: 1.144 \r\n"
				+ "ESPN.com\r\n"
				+ "\r\n"
				+ "홈런: 53개 \r\n"
				+ "StatMuse\r\n"
				+ "+1\r\n"
				+ "\r\n"
				+ "타점(RBI): 114점 \r\n"
				+ "StatMuse\r\n"
				+ "\r\n"
				+ "득점: 137점");
		vo.setWriter("chatGPT");
		
		int result = mapper.update(vo);
		if(result > 0) {
			log.info(MyUtil.getColor() + vo.getBno() + "번 글 수정 성공" + MyUtil.END);
		}
		else {
			log.info(MyUtil.getColor() + "글 수정 대실패" + MyUtil.END);
		}
	}
	
	@Test
	public void testGet() {
		Long bno = 4L;
		BoardVO vo = mapper.get(bno);
		log.info(MyUtil.getColor() + "Read VO : " + vo + MyUtil.END);
	}
}
