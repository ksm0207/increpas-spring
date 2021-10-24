package spring.bbs.util;

public class PageNation {
	
	int nowPage=1; // 현재 페이지.
	int perPage=5; // nowPage =1 당 보여지는 게시물 수
	int perBlock = 5; // 한 블럭당 보여질 페이지 수
	int totalRecord = 0; // bbs_t 전체 게시물 수를 저장할 변수
	int totalPage = 0; // 전체 페이지 수
	int start = 0 ; // 한 페이지에서 보여지는 게시물의 행 번호
	int end =0 ; // 한 페이지에서 보여지는 게시물의 마지막 행 번호
	
	/*
	 	start , end 역할은 클라이언트 화면에 다음과 같이 보여진다.
	 	
	 	start 1 번호 제목 글쓴이 작성일 조회수 등등
	 		  2  
	 		  3  위와 동일
	 		  4
	 	end   5
	 */
	
	int firstPageBlock = 0; // 보여질 페이지 블럭의 시작페이지 값
	int lastPageBlock =0;   // 보여질 페이지 블럭의 마지막페이지 값
	
	/*
	    firstPageBlock 과 lastPageBlock 역할
	    
	  	start 1 번호 제목 글쓴이 작성일 조회수 등등
	 		  2  
	 		  3  
	 		  4
	 	end   5
	         [1] [2] [3] [4] [5] ...
	          f               l
	 * */
	
	public PageNation() {
		
	}
	//                       5            5
	public PageNation(int perPage, int perBlock) {
		this.perPage=perPage;
		this.perBlock=perBlock;
	}
	
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		
		// 현재 페이지가 전체페이수보다 크다면.
		// nowPage 6  totalPage = 5
		if(nowPage > totalPage) {
			// 6 = 5 --> 5
			nowPage = totalPage;
		}
		
		// 현재페이지 - 1 * 게시글 수 + 1
		start = (nowPage -1) * perPage + 1; // 1
		end = nowPage * perPage; //         // 5
		
		// nowPage = 1
		// start = 1
		// end = 5
		
		// nowPage = 2
		// start = 6
		// end = 10
		
		firstPageBlock = (int) ( (nowPage) - 1 / perBlock) * perBlock + 1; // 1
		lastPageBlock = firstPageBlock + perBlock -1; // 5
		
		// 마지막페이지 블럭이 총 페이지 값을 넘길 경우.
		if(lastPageBlock > totalPage) {
			lastPageBlock = totalPage;
		}
		
	}
	
	
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		totalPage = (int)Math.ceil((double) totalRecord / perPage);
		// totalPage = 5
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getFirstPageBlock() {
		return firstPageBlock;
	}
	public void setFirstPageBlock(int firstPageBlock) {
		this.firstPageBlock = firstPageBlock;
	}
	public int getLastPageBlock() {
		return lastPageBlock;
	}
	public void setLastPageBlock(int lastPageBlock) {
		this.lastPageBlock = lastPageBlock;
	}
	
}
