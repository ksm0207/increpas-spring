package mybatis.vo;

import org.springframework.web.multipart.MultipartFile;

public class EditorImageVO {

	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
