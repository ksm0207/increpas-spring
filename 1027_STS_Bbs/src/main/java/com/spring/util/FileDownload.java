package com.spring.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 * 
 *  웹상에서 / FileDownload로 호출 할 수 있도록
 *  web.xml에서 등록을 해줘야한다 !
 *  - servlet 태그와 servlet mapping 태그
 *  
 */
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 값 받기 - dir, filename
		
		String dir = request.getParameter("dir"); // 파일이 저장되는 위치,
		System.out.println("Dir :" + dir);        // 절대경로화 시킬것.                                  
		String filename = request.getParameter("filename"); // 파일
		System.out.println("filename :" + filename);
		
		// 절대경로 선언
		String realPath = getServletContext().getRealPath(dir);
		// 파일명과 연결하여 전체경로 만들기
		String fullPath = realPath+System.getProperty("file.separator")+filename;
		System.out.println("FullPath :" + fullPath);
		
		// 파일 객체 생성
		File file = new File(fullPath);
		System.out.println("File 객체 :" + file);
		
		if(file.exists() && file.isFile()) {
			// 파일 객체가 경로에 존재하고 데이터가 파일 일 경우
			
			// 파일 읽기를 위한 바구니
			byte[] buf = new byte[2048];
			// 전송할 데이터가 스트림 처리될 때 (읽고 나갈때)
			// 문자셋 지정을 해준다
			response.setContentType("application/octet-stream; charset=8859_1");
			
			// 다운로드 대화상자 구현하기
			// Key값은 정해져있는것
			response.setHeader("Content-Disposition", "attachment;filename="+
								new String(filename.getBytes(),"8859_1"));
			
			
			response.setHeader("Content-Transfer-Encoding", "binary");

			// 파일 Input
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			
			// 스트림 처리 후 요청 한 곳으로 보내기 위해 스트림을 응답객체로부터 얻어내준다
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			int size = -1;
			
			try {
				// 읽고 쓰기
				while( (size = bis.read(buf)) != -1) {
					bos.write(buf,0,size);
					bos.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(bos != null) {
					bos.close();
					System.out.println("bos종료");
				}
				if(bis != null) {
					bis.close();
					System.out.println("bis종료");
				}
				
			}

		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
