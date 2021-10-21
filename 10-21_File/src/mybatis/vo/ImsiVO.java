package mybatis.vo;

import org.springframework.web.multipart.MultipartFile;

public class ImsiVO {
	
	private String idx;
	private String title;
	private String content;
	private String file_name; // 파일 이름 저장
	private String reg_date;
	
	// 첨부파일 파라미터 명과 동일한 이름으로 변수를 선언한다.
	private MultipartFile s_file; // 첨부되는 실제 파일

	// 위와 같이 첨부된 파일이 자동으로 들어오도록 하기위해
		// Controller-servlet.xml에서 multipartResolver를 정의해야함.
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public MultipartFile getS_file() {
		return s_file;
	}

	public void setS_file(MultipartFile s_file) {
		this.s_file = s_file;
	}
	
	
	
	
}
