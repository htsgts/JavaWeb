package com.koreait.board.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public String uploadAjaxPost(MultipartFile[] uploadFile) {
		String uploadFolder = "C:/upload";
		File uploadPath = new File(uploadFolder, getFolder());
		if(!uploadPath.exists())
			uploadPath.mkdirs();
		
		for(MultipartFile f : uploadFile) {
			log.info("Upload FileName : " + f.getOriginalFilename());
			log.info("Upload FileSize : " + f.getSize());
			
			String uploadFileName = f.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
//			File saveFile = new File(uploadFolder, f.getOriginalFilename());
//			File saveFile = new File(uploadPath, f.getOriginalFilename());
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				f.transferTo(saveFile);
				
				if(checkImage(saveFile)) {  // 이미지이면
					log.info("이미지");
				}
				else {  // 이미지가 아니면
					log.info("이미지 아님");
				}
			}
			catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return "/board/list";
	}
	
	private String getFolder() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(date);
		return str;
	}
	
	private boolean checkImage(File file) {
		// image이면 true, 아니면 false 리턴
		// Files.probeContentType()를 이용
		try {
			String contentType = Files.probeContentType(file.toPath());
			// image/jpeg, image/png, text/plain
			return contentType.startsWith("image");
		}
		catch(Exception e) { e.printStackTrace(); }
		
		return false;
	}
	
	
//	@GetMapping("test")
//	@ResponseBody
//	public String testRest(String user) {
//		if(user.equals("admin")) {
//			return "너무 훌륭하세요";
//		}
//		return "너 누구야";
//	}
	
	
	
}
