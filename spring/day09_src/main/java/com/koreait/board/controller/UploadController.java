package com.koreait.board.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/upload/*")
public class UploadController {

	@GetMapping("uploadForm")
	public void uploadForm() {
		
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {
		
	}
	
	@PostMapping("uploadFormPost")
	public String uploadFormPost(MultipartFile[] uploadFile) {
		String uploadFolder = "C:/upload";
		
		for(MultipartFile f : uploadFile) {
			log.info("Upload FileName : " + f.getOriginalFilename());
			log.info("Upload FileSize : " + f.getSize());
			
			File saveFile = new File(uploadFolder, f.getOriginalFilename());
			
			try {
				f.transferTo(saveFile);
			}
			catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return "/board/list";
	}
	
	@PostMapping("uploadAjaxPost")
	public String uploadAjaxPost(MultipartFile[] uploadFile) {
		String uploadFolder = "C:/upload";
		
		for(MultipartFile f : uploadFile) {
			log.info("Upload FileName : " + f.getOriginalFilename());
			log.info("Upload FileSize : " + f.getSize());
			
			File saveFile = new File(uploadFolder, f.getOriginalFilename());
			
			try {
				f.transferTo(saveFile);
			}
			catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return "/board/list";
	}
}
