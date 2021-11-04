package com.Bbs.Util;

public class PageMarker {

	private int currentPage;   // 현재페이지
	private int bbsRowTotal;   // SELECT * COUNT(*) 게시판 총합
	private int bbsTotal;      // 전체페이지 
	private int boardList;     // 화면에 나타낼 게시물 수
	private int pageBlock;     // 화면에 나타낼 페이지 수
	private int startPage;     // 화면에 나타날 첫번째 페이지 수
	private int finalPage;     // 화면에 나타낼 마지막 페이지 수
	private int begin;         // 게시물의 첫번째 행 번호
	private int end;           // 게시물의 마지막 행 번호
	private boolean prePage;   // 이전기능
	private boolean nextPage ; // 다음 기능
	
	public PageMarker(int currentPage , int bbsRowTotal , int boardList, int pageBlock) {
		
		this.currentPage = currentPage;
		this.bbsRowTotal = bbsRowTotal;
		this.boardList = boardList;
		this.pageBlock = pageBlock;
		
		
		bbsTotal = (int)Math.ceil((double)bbsRowTotal / boardList);
		System.out.println("전체페이지 :" + bbsTotal);
	
		if( bbsTotal < currentPage) {
			System.out.println("True");
			currentPage = bbsTotal;
			System.out.println(currentPage);
		}
		
		// start & end 값
		startPage = (int)((currentPage - 1) / pageBlock) * pageBlock +1;
		finalPage = startPage + pageBlock -1;
		
		if(finalPage > bbsTotal) {
			finalPage = bbsTotal;
		}
		
		// begin & end
		begin = (currentPage - 1) * boardList + 1;
		end = currentPage * boardList;
		
		if(startPage > 1) {
			prePage = true;
		}
		if(finalPage < bbsTotal) {
			nextPage = true;
		}
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBbsRowTotal() {
		return bbsRowTotal;
	}

	public void setBbsRowTotal(int bbsRowTotal) {
		this.bbsRowTotal = bbsRowTotal;
	}

	public int getBbsTotal() {
		return bbsTotal;
	}

	public void setBbsTotal(int bbsTotal) {
		this.bbsTotal = bbsTotal;
	}

	public int getBoardList() {
		return boardList;
	}

	public void setBoardList(int boardList) {
		this.boardList = boardList;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
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
		return prePage;
	}

	public void setPrePage(boolean prePage) {
		this.prePage = prePage;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}
}
