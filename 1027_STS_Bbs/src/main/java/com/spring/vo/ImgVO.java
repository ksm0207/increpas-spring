package com.spring.vo;

import org.springframework.web.multipart.MultipartFile;

public class ImgVO {
	
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
