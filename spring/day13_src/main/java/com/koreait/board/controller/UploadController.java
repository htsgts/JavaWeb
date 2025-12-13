package com.koreait.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.board.bean.vo.AttachFileVO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

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
	public List<AttachFileVO> uploadAjaxPost(MultipartFile[] uploadFile) {
		String uploadFolder = "C:/upload";
		List<AttachFileVO> fileList = new ArrayList();
		
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
			
			AttachFileVO attach = new AttachFileVO();
			attach.setFileName(f.getOriginalFilename());
			attach.setUuid(uuid.toString());
			attach.setUploadPath(getFolder());
			
			try {
				f.transferTo(saveFile);
				
				if(checkImage(saveFile)) {  // 이미지이면
					log.info("이미지");
					attach.setImage(true);
					
					// 이미지이면 섬네일을 만들어준다.
					FileOutputStream thumbnail =
							new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					
					// 32, 32라는 파라미터를 주면 가로와 세로 중 넓은 쪽을 32로 맞춘다. 비율은 그대로
					Thumbnailator.createThumbnail(f.getInputStream(), thumbnail, 32, 32);
					thumbnail.close();
				}
				else {  // 이미지가 아니면
					log.info("이미지 아님");
					attach.setImage(false);
				}
			}
			catch(Exception e) {
				log.error(e.getMessage());
			}
			
			fileList.add(attach);
		}
		
		return fileList;
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
	
	// 이미지 파일 조회가 필요할 때 호출되는 메서드
	@GetMapping("display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		
		ResponseEntity<byte[]> result = null;
		
		log.info("fileName : " + fileName);
		File file = new File("C:/upload/" + fileName);
		// display?fileName=2025/12/06/image.png
		
		HttpHeaders header = new HttpHeaders();
		try {
			// 헤더에 적합한 타입 표시
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),
					                            header, HttpStatus.OK);
		}
		catch(Exception e) { e.printStackTrace(); }
		
		return result;
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
