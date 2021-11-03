package kr.go.vo;

public class DataVO {
	// 공공데이터 - 14)	[행사정보 조회] 오퍼레이션 명세
	private String title;
	private String addr1;
	private String addr2;
	private String tel;
	private String firstimage;
	private String firstimage2;
	private String eventstartdate;
	private String eventenddate;
	private String mapx;
	private String mapy;
	
	public DataVO(String title, String addr1, String addr2, String tel, String firstimage,
			      String firstimage2, String eventstartdate, String eventenddate,
			      String mapx, String mapy)
	{
		this.title=title;
		this.addr1=addr1;
		this.addr2=addr2;
		this.tel=tel;
		this.firstimage=firstimage;
		this.firstimage2=firstimage2;
		this.eventstartdate=eventstartdate;
		this.eventenddate=eventenddate;
		this.mapx=mapx;
		this.mapy=mapy;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getFirstimage2() {
		return firstimage2;
	}
	public void setFirstimage2(String firstimage2) {
		this.firstimage2 = firstimage2;
	}
	public String getEventstartdate() {
		return eventstartdate;
	}
	public void setEventstartdate(String eventstartdate) {
		this.eventstartdate = eventstartdate;
	}
	public String getEventenddate() {
		return eventenddate;
	}
	public void setEventenddate(String eventenddate) {
		this.eventenddate = eventenddate;
	}
	public String getMapx() {
		return mapx;
	}
	public void setMapx(String mapx) {
		this.mapx = mapx;
	}
	public String getMapy() {
		return mapy;
	}
	public void setMapy(String mapy) {
		this.mapy = mapy;
	}
	
	
}
