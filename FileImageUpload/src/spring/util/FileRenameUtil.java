package spring.util;

import java.io.File;

public class FileRenameUtil {

	public static String checkSameFileName(String fileName, String path) {
		
		//인자인 fileName에서 확장자를 뺀 파일명 가려내자!
		//우선 "."의 위치를 알아내야 한다.
		System.out.println("FileRenameUtil");
		
		int period = fileName.lastIndexOf("."); // test123.txt --> 7
		System.out.println("Period : " + period);
	
		String f_name = fileName.substring(0, period); // test123
		String suffix = fileName.substring(period); // .txt
		
		System.out.println("f_name :" + f_name);
		System.out.println("suffix : "+suffix);
		
		//전체 경로
		String saveFileName = path + System.getProperty("file.separator") +fileName;
		System.out.println("SaveFileName : " + saveFileName);
		
		File f = new File(saveFileName);
		
		//같은 이름이 있을 경우 파일명 뒤에 숫자를 붙여준다.
		int idx = 1;
		while(f != null && f.exists()) {
			
			//파일이 이미 존재하므로 이름을 변경하자!
			StringBuffer sb = new StringBuffer();
			sb.append(f_name);
			sb.append(idx++); //변경된 이름이 있을 수도 있으므로 idx값을 일단 1 증가시킴!
			sb.append(suffix);
			
			fileName = sb.toString(); // test1231.txt
			System.out.println("FileName : " + fileName);
			saveFileName = path + System.getProperty("file.separator") +fileName;
			System.out.println("saveFileName : " + saveFileName);
			f = new File(saveFileName);
			
		}//while의 끝
		System.out.println("return : " + fileName);
		return fileName;
	}
}






