package com.spring.util;

public class Paging {

	// 변수 11개
	private int nowPage; // 현재 페이지 값을 나타낸다.
	private int rowTotal; // 게시물의 총합을 나타낸다.
	private int totalPage; // 전체 페이지 수
	private int blockList; // 게시판에서 나타낼 갯수를 표현해준다.
	private int blockPage; // 화면에 나타낼 페이지 수를 나타낸다 [1][2][3]...
	private int startPage; // 시작페이지 값
	private int endPage;   // 마지막페이지 값
	private boolean isPrePage;   // 이전 기능으로..
	private boolean isNextPage;  // 다음 기능으로..
	private int begin; // 표현할 게시물의 첫번째 행 을 나타낸다
	private int end;   //                 마지막 행 을 나타낸다.
	
	private StringBuffer sb;
	
	
	
	public Paging(int nowPage , int rowTotal, int blockList, int blockPage) {
		
		this.nowPage=nowPage;
		this.rowTotal=rowTotal;
		this.blockList=blockList;
		this.blockPage=blockPage;
		
		// ※ 게시물총합 / 게시판에 나타낼 갯수
		totalPage =   (int) Math.ceil((double)rowTotal / blockList) ;
		System.out.println("게시물 페이지 수 : "+totalPage);
		// totalPage = 39 / 5 ... -> SaveData : (7 ... 4)
		// Math.ceil() --> 8
		// 1 ~ 9 Page
		
		// 현재 페이지 값이 전체 페이지 값 보다 크다면
		// 현재 페이지 값으로 지정해줘서 막아주기
		if(nowPage > totalPage) {
			nowPage = totalPage;
		}
		
		// startPage endPage 값 구하기
		
		startPage = (int)((nowPage - 1) / blockPage) * blockPage +1;
		System.out.println("StartPage : " + startPage);
		endPage = startPage + blockPage -1;
		System.out.println("EndPage : " + endPage);
		
		// 마지막 페이지의 값이 전체 페이지 값 보다 클 경우
		// 예를들어 총 페이지는 4인데 endPage가 5이상 나올경우
		// 없는페이지가 나타나기 때문에 이거를 막아준다
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		// 현재 페이지 값에 따라 게시물의 행번호를 구한다
		
		begin = (nowPage-1) * blockList + 1; // 첫번째 행 구하기
		end = nowPage * blockList; // 마지막 행 구하기
		
		
		if(startPage > 1) {
			isPrePage = true;
		}
		if(endPage < totalPage) {
			isNextPage = true;
		}
	}
	
	
	
	
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	public boolean isPrePage() {
		return isPrePage;
	}
	public void setPrePage(boolean isPrePage) {
		this.isPrePage = isPrePage;
	}
	public boolean isNextPage() {
		return isNextPage;
	}
	public void setNextPage(boolean isNextPage) {
		this.isNextPage = isNextPage;
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
	
}
