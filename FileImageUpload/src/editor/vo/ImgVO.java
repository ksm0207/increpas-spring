package editor.vo;

import org.springframework.web.multipart.MultipartFile;

public class ImgVO {
	private MultipartFile s_file; // 파라미터 명과 맞췄다.

	public MultipartFile getS_file() {
		return s_file;
	}

	public void setS_file(MultipartFile s_file) {
		this.s_file = s_file;
	}
}
