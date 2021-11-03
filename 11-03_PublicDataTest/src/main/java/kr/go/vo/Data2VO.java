package kr.go.vo;

public class Data2VO {

	/*
	공고번호 물건번호 용도명 물건명 입찰번호
	물건소새지(지번) 처분방식코드 입찰방식명
	최저입찰가 감정가 최저입찰가율
	입찰시작일시 / 마감일시
	물건상태
	유찰횟수
 	*/
	
	private String PLNM_NO; // 공고번호
	private String CLTR_NO; // 물건번호
	private String CTGR_FULL_NM; // 용도명
	private String CLTR_NM;     // 물건명
	private String BID_MNMT_NO; // 입찰번호
	private String LDNM_ADRS; // 물건 소새지(지번)
	private String DPSL_MTD_CD; // 처분방식코드
	private String BID_MTD_NM ; // 입찰방식명
	private String MIN_BID_PRC; // 최저입찰가
	private String APSL_ASES_AVG_AMT; // 감정가
	private String FEE_RATE; // 최저입찰가율
	private String PBCT_BEGN_DTM; // 입찰시작일시
	private String PBCT_CLS_DTM; // 입찰 마감 일시
	private String PBCT_CLTR_STAT_NM; // 물건 상태
	private String USCBD_CNT; // 유찰 횟수
	
	
	public String getPLNM_NO() {
		return PLNM_NO;
	}
	public void setPLNM_NO(String pLNM_NO) {
		PLNM_NO = pLNM_NO;
	}
	public String getCLTR_NO() {
		return CLTR_NO;
	}
	public void setCLTR_NO(String cLTR_NO) {
		CLTR_NO = cLTR_NO;
	}
	public String getCTGR_FULL_NM() {
		return CTGR_FULL_NM;
	}
	public void setCTGR_FULL_NM(String cTGR_FULL_NM) {
		CTGR_FULL_NM = cTGR_FULL_NM;
	}
	public String getCLTR_NM() {
		return CLTR_NM;
	}
	public void setCLTR_NM(String cLTR_NM) {
		CLTR_NM = cLTR_NM;
	}
	public String getBID_MNMT_NO() {
		return BID_MNMT_NO;
	}
	public void setBID_MNMT_NO(String bID_MNMT_NO) {
		BID_MNMT_NO = bID_MNMT_NO;
	}
	public String getLDNM_ADRS() {
		return LDNM_ADRS;
	}
	public void setLDNM_ADRS(String lDNM_ADRS) {
		LDNM_ADRS = lDNM_ADRS;
	}
	public String getDPSL_MTD_CD() {
		return DPSL_MTD_CD;
	}
	public void setDPSL_MTD_CD(String dPSL_MTD_CD) {
		DPSL_MTD_CD = dPSL_MTD_CD;
	}
	public String getBID_MTD_NM() {
		return BID_MTD_NM;
	}
	public void setBID_MTD_NM(String bID_MTD_NM) {
		BID_MTD_NM = bID_MTD_NM;
	}
	public String getMIN_BID_PRC() {
		return MIN_BID_PRC;
	}
	public void setMIN_BID_PRC(String mIN_BID_PRC) {
		MIN_BID_PRC = mIN_BID_PRC;
	}
	public String getAPSL_ASES_AVG_AMT() {
		return APSL_ASES_AVG_AMT;
	}
	public void setAPSL_ASES_AVG_AMT(String aPSL_ASES_AVG_AMT) {
		APSL_ASES_AVG_AMT = aPSL_ASES_AVG_AMT;
	}
	public String getFEE_RATE() {
		return FEE_RATE;
	}
	public void setFEE_RATE(String fEE_RATE) {
		FEE_RATE = fEE_RATE;
	}
	public String getPBCT_BEGN_DTM() {
		return PBCT_BEGN_DTM;
	}
	public void setPBCT_BEGN_DTM(String pBCT_BEGN_DTM) {
		PBCT_BEGN_DTM = pBCT_BEGN_DTM;
	}
	public String getPBCT_CLS_DTM() {
		return PBCT_CLS_DTM;
	}
	public void setPBCT_CLS_DTM(String pBCT_CLS_DTM) {
		PBCT_CLS_DTM = pBCT_CLS_DTM;
	}
	public String getPBCT_CLTR_STAT_NM() {
		return PBCT_CLTR_STAT_NM;
	}
	public void setPBCT_CLTR_STAT_NM(String pBCT_CLTR_STAT_NM) {
		PBCT_CLTR_STAT_NM = pBCT_CLTR_STAT_NM;
	}
	public String getUSCBD_CNT() {
		return USCBD_CNT;
	}
	public void setUSCBD_CNT(String uSCBD_CNT) {
		USCBD_CNT = uSCBD_CNT;
	}
	
	
	
}
