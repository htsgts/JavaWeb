package com.koreait.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.koreait.board.bean.dao.BoardDAO;
import com.koreait.board.bean.vo.BoardVO;
import com.koreait.board.util.MyUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("register")
	public void registForm() {
		
	}
	
	@PostMapping("register")
	public RedirectView register(BoardVO board, RedirectAttributes rttr){
		// 본체로부터 받은 title, content, writer를 출력해보세요.
		log.info("register called");
		log.info("board : " + board);
		int result = dao.register(board);
		if(result > 0) {
			log.info("글 등록이 성공하였습니다.");
		}
		else {
			log.info("너 지금 뭐 보낸거냐");
		}
		
		rttr.addFlashAttribute("msg", board.getBno() + "번 글 등록이 완료되었습니다.");
		return new RedirectView("list");
	}
	
	// list
	@GetMapping("list")
	public void list(String type, String keyword, Model model) {
		log.info("------------------------------------->");
		log.info(MyUtil.getColor() + "getList : " + type + "-" + keyword + MyUtil.END);
//		dao.getList().forEach(board->log.info(MyUtil.getColor() + board + MyUtil.END));
//		model.addAttribute("board", dao.getList());
		dao.getListWithKey(type, keyword).forEach(board->log.info(MyUtil.getColor() + board + MyUtil.END));
		model.addAttribute("board", dao.getListWithKey(type, keyword));
		model.addAttribute("myFeel", "very gloomy");
	}
	
	// read
	// localhost:10000/board/read?bno=N
	@GetMapping("read")
	public void read(Long bno, Model model) {
		BoardVO vo = dao.read(bno);
		log.info("read : " + vo);
		model.addAttribute("vo", vo);
	}
	
	// remove
	@PostMapping("remove")
	public RedirectView remove(Long bno, RedirectAttributes rttr) {
		if(dao.remove(bno) > 0)
			rttr.addFlashAttribute("msg", bno + "번 글 삭제 성공");
		else
			rttr.addFlashAttribute("msg", "글 삭제 대실패");
		
		return new RedirectView("list");
	}
	
	// read
	// localhost:10000/board/modify?bno=N
	@GetMapping("modify")
	public void modify(Long bno, Model model) {
		BoardVO vo = dao.read(bno);
		log.info("modify : " + vo);
		model.addAttribute("vo", vo);
	}
	
	@PostMapping("modify")
	public RedirectView modify2(BoardVO board, RedirectAttributes rttr) {
		log.info("modify board : " + board);
		int result = dao.modify(board);
		if(result > 0)
			rttr.addFlashAttribute("msg", board.getBno() + "번 글 수정완료");
		else
			rttr.addFlashAttribute("msg", "수정 대실패");
		
		return new RedirectView("list");
	}
}
