package net.koreate.file.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileVO {
	
	private String auth;
	private String content;
	private List<MultipartFile> file;
	private MultipartFile file1;

}



