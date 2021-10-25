package spring.util;

public class Paging {

	private int nowPage;        // 현재페이지
	private int rowTotal;       // 총 게시물 수
	private int blockList;      // 한 페이지에 표현 될 게시물 수
	private int blockPage;      // 한 블럭당 표현 할 페이지 수 (5)
	private int totalPage;      // 전체 페이지 수
	private int startPage;      // 시작페이지 값
	private int endPage;        // 마지막페이지 값
	private int begin;          // 한 페이지에 보여질 시작 레코드 행번호(rownum)
	private int end;            // 한 페이지에 마지막 으로 보여질 행번호
	private boolean isPrePage;  // 이전 기능 가능여부
	private boolean isnextPage; // 다음 기능 가능여부
	
	private StringBuffer sb;    // JSP에서 표현 할 페이징 HTML코드를 저장할 공간 선언
	
	public Paging(int nowPage, int rowTotal, int blockList, int blockPage) {
		
		this.nowPage=nowPage;
		this.rowTotal=rowTotal;
		this.blockList=blockList;
		this.blockPage=blockPage;
		
		
		// 이전기능 , 다음기능 초기화
		isnextPage = false;
		isPrePage= false;
		
		// 입력된 전체게시물의 수를 통해 전체 페이지 값을 구한다.
		totalPage = (int)(Math.ceil((double)rowTotal / blockList)); // 32 / 10
		
		// 현재 페이지의 값이 전체페이지의 값보다 크다면 전체페이지 값을
		// 현재 페이지 값으로 지정한다.
		
		if(nowPage > totalPage) {
			nowPage = totalPage;
		}
		
		// 현재 블럭의 시작페이지 값과 마지막 페이지 값을 구하기.
		startPage = (int)((nowPage - 1) / blockPage) * blockPage +1;
		endPage = startPage * blockPage -1;
		
		// 마지막 페이지의 값이 전체 페이지의 값이 클 경우.
		// 총 페이지 4 end 가 5일경우 막아준다. 5는 없는 페이지임
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		// 현재 페이지 값에 의해 시작게시물의 행 번호
		//                       마지막 게시물의 행번호를 지정하여
		//                       현재 페이지에 보여질 게시물 목록을 얻는다
		begin = (nowPage -1) * blockList +1; // 1-1 * 10 + 1 -> 1
		end = nowPage * blockList; // 1 * 10 = 10
		
		// 이전기능 가능여부 확인
		if(startPage > 1) {
			isPrePage = true;
		}
		
		// 다음기능 가능여부 확인
		if(endPage < totalPage) {
			isnextPage = true;
		}
		
		// 현재 페이지 값 과 시작페이지 , 마지막페이지 값을 알았으니
		// 페이지 기법에 사용할 코드를 작성하여 StringBuffer에 저장하자
		
		sb = new StringBuffer();
		
		if(isPrePage) { // 이전기능이 활성화 되려면 최소 은 5이상이다.
			
			sb.append("<li><a href='list.do?cPage=");
			sb.append(nowPage - blockPage); // 6 - 5 --> nowPage : 1
			sb.append("'>이전</a></li>");
		
			
		}else {
			sb.append("<li></li>");
		}
		// 페이지 번호를 출력하는 반복문
		for(int i= startPage; i<=endPage; i++) {
			
			// i의 값이 현재페이지의 값과 같을 때는 숫자만 출력하기
			if(i == nowPage) {
				sb.append("<li>");
				sb.append(i);
				sb.append("</li>");
				
			}else {
				/*
				 * <ul>
				 * 	<li><a href='list.do?cPage=i'>i</a></li>
				 * </ul>
				 * */ 
				
				sb.append("<li><a href='list.do?cPage=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a></li>");
				
			}
		}// end of for
		
		// 다음기능 가능여부를 확인
		if(isnextPage) {
		
			sb.append("<li><a href='list.do?cPage=");
			sb.append(nowPage + blockPage);
			sb.append("'> &gt; </a></li>");
		
		}else {
			
			sb.append("<li>");
			sb.append("&gt;");
			sb.append("</li>");
		}
		
	}
	
	/*
	   isPrePage : true ->  이전기능 활성화  다음기능 비활성화
	   isnextPage : true -> 다음기능 활성화 이전기능 비활성화
	 * */
	
	

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getRowTotal() {
		return rowTotal;
	}

	public void setRowTotal(int rowTotal) {
		this.rowTotal = rowTotal;
	}

	public int getBlockList() {
		return blockList;
	}

	public void setBlockList(int blockList) {
		this.blockList = blockList;
	}
	
	public int getBlockPage() {
		return blockPage;
	}
	
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrePage() {
		return isPrePage;
	}

	public void setPrePage(boolean isPrePage) {
		this.isPrePage = isPrePage;
	}

	public boolean isIsnextPage() {
		return isnextPage;
	}

	public void setIsnextPage(boolean isnextPage) {
		this.isnextPage = isnextPage;
	}

	public StringBuffer getSb() {
		return sb;
	}

	public void setSb(StringBuffer sb) {
		this.sb = sb;
	}
	
}
