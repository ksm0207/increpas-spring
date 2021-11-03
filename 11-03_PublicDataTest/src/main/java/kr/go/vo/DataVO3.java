package kr.go.vo;

public class DataVO3 {

	/* 
		DATA : 이용자 제한 , 충전기상태 , 운영기관연락처 , 운영기관명 , 이용가능시간
		위도 , 경도
	    주소 , 충전기타입 , 충전기ID ,  충전소ID , 충전소 이름
    */
	
	private String limitYn; // 이용자 제한
	private String stat; // 충전기상태
	private String busiCall; // 운영기관연락처
	private String busiNm; // 운영기관명
	private String useTime; // 이용가능시간
	private String lat; // 위도
	private String lng; // 경도
	private String addr; // 주소 
	private String chgerType; // 충전기타입
	private String chgerid; // 충전기
	private String statid; // 충전소
	private String statNm; // 충전소 이름
	private String note; // 충전소 안내
	
	
	
	public DataVO3(String limitYn, String stat, String busiCall, String busiNm, String useTime, String lat, String lng,
			String addr, String chgerType, String chgerid, String statid, String statNm, String note) {
		super();
		this.limitYn = limitYn;
		this.stat = stat;
		this.busiCall = busiCall;
		this.busiNm = busiNm;
		this.useTime = useTime;
		this.lat = lat;
		this.lng = lng;
		this.addr = addr;
		this.chgerType = chgerType;
		this.chgerid = chgerid;
		this.statid = statid;
		this.statNm = statNm;
		this.note=note;
	}
	
	public String getLimitYn() {
		return limitYn;
	}
	public void setLimitYn(String limitYn) {
		this.limitYn = limitYn;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getBusiCall() {
		return busiCall;
	}
	public void setBusiCall(String busiCall) {
		this.busiCall = busiCall;
	}
	public String getBusiNm() {
		return busiNm;
	}
	public void setBusiNm(String busiNm) {
		this.busiNm = busiNm;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getChgerType() {
		return chgerType;
	}
	public void setChgerType(String chgerType) {
		this.chgerType = chgerType;
	}
	public String getChgerid() {
		return chgerid;
	}
	public void setChgerid(String chgerid) {
		this.chgerid = chgerid;
	}
	public String getStatid() {
		return statid;
	}
	public void setStatid(String statid) {
		this.statid = statid;
	}
	public String getStatNm() {
		return statNm;
	}
	public void setStatNm(String statNm) {
		this.statNm = statNm;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
}
