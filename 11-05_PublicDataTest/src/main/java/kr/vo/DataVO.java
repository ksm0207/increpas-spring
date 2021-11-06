package kr.vo;

public class DataVO {
	
	private String RNUM;
	private String PLNM_NO; // 공고번호
	private String PBCT_NO; // 공매번호
	private String PBCT_CDTN_NO; // 공매조건번호
	private String CLTR_NO; // 물건번호
	private String CLTR_HSTR_NO; // 물건이력번호
	private String SCRN_GRP_CD; // 화면그룹코드
	private String CTGR_FULL_NM; // 용도명
	private String BID_MNMT_NO; // 입찰번호
	private String CLTR_NM; // 물건명
	private String CLTR_MNMT_NO; // 물건관리번호
	private String LDNM_ADRS; // 물건소재지(지번)
	private String NMRD_ADRS; // 물건소재지(도로명)
	private String LDNM_PNU; // 
	private String DPSL_MTD_CD; // 처분방식코드
	private String DPSL_MTD_NM; // 처분방식코드명
	private String BID_MTD_NM; //  입찰방식명
	private String MIN_BID_PRC; // 최저입찰가
	private String APSL_ASES_AVG_AMT; // 감정가
	private String FEE_RATE; // 최저입찰가율
	private String PBCT_BEGN_DTM; // 입찰시작일시
	private String PBCT_CLS_DTM;  // 입찰마감일시
	private String PBCT_CLTR_STAT_NM; // 물건상태
	private String USCBD_CNT; // 유찰횟수
	private String IQRY_CNT;  // 조회수
	private String GOODS_NM;  // 물건상세정보

	
	
	
	
	public DataVO(String rNUM, String pLNM_NO, String pBCT_NO, String pBCT_CDTN_NO, String cLTR_NO, String cLTR_HSTR_NO,
			String sCRN_GRP_CD, String cTGR_FULL_NM, String bID_MNMT_NO, String cLTR_NM, String cLTR_MNMT_NO,
			String lDNM_ADRS, String nMRD_ADRS, String lDNM_PNU, String dPSL_MTD_CD, String dPSL_MTD_NM,
			String bID_MTD_NM, String mIN_BID_PRC, String aPSL_ASES_AVG_AMT, String fEE_RATE, String pBCT_BEGN_DTM,
			String pBCT_CLS_DTM, String pBCT_CLTR_STAT_NM, String uSCBD_CNT, String iQRY_CNT, String gOODS_NM) {
		super();
		RNUM = rNUM;
		PLNM_NO = pLNM_NO;
		PBCT_NO = pBCT_NO;
		PBCT_CDTN_NO = pBCT_CDTN_NO;
		CLTR_NO = cLTR_NO;
		CLTR_HSTR_NO = cLTR_HSTR_NO;
		SCRN_GRP_CD = sCRN_GRP_CD;
		CTGR_FULL_NM = cTGR_FULL_NM;
		BID_MNMT_NO = bID_MNMT_NO;
		CLTR_NM = cLTR_NM;
		CLTR_MNMT_NO = cLTR_MNMT_NO;
		LDNM_ADRS = lDNM_ADRS;
		NMRD_ADRS = nMRD_ADRS;
		LDNM_PNU = lDNM_PNU;
		DPSL_MTD_CD = dPSL_MTD_CD;
		DPSL_MTD_NM = dPSL_MTD_NM;
		BID_MTD_NM = bID_MTD_NM;
		MIN_BID_PRC = mIN_BID_PRC;
		APSL_ASES_AVG_AMT = aPSL_ASES_AVG_AMT;
		FEE_RATE = fEE_RATE;
		PBCT_BEGN_DTM = pBCT_BEGN_DTM;
		PBCT_CLS_DTM = pBCT_CLS_DTM;
		PBCT_CLTR_STAT_NM = pBCT_CLTR_STAT_NM;
		USCBD_CNT = uSCBD_CNT;
		IQRY_CNT = iQRY_CNT;
		GOODS_NM = gOODS_NM;
	}
	public String getRNUM() {
		return RNUM;
	}
	public void setRNUM(String rNUM) {
		RNUM = rNUM;
	}
	public String getPLNM_NO() {
		return PLNM_NO;
	}
	public void setPLNM_NO(String pLNM_NO) {
		PLNM_NO = pLNM_NO;
	}
	public String getPBCT_NO() {
		return PBCT_NO;
	}
	public void setPBCT_NO(String pBCT_NO) {
		PBCT_NO = pBCT_NO;
	}
	public String getPBCT_CDTN_NO() {
		return PBCT_CDTN_NO;
	}
	public void setPBCT_CDTN_NO(String pBCT_CDTN_NO) {
		PBCT_CDTN_NO = pBCT_CDTN_NO;
	}
	public String getCLTR_NO() {
		return CLTR_NO;
	}
	public void setCLTR_NO(String cLTR_NO) {
		CLTR_NO = cLTR_NO;
	}
	public String getCLTR_HSTR_NO() {
		return CLTR_HSTR_NO;
	}
	public void setCLTR_HSTR_NO(String cLTR_HSTR_NO) {
		CLTR_HSTR_NO = cLTR_HSTR_NO;
	}
	public String getSCRN_GRP_CD() {
		return SCRN_GRP_CD;
	}
	public void setSCRN_GRP_CD(String sCRN_GRP_CD) {
		SCRN_GRP_CD = sCRN_GRP_CD;
	}
	public String getCTGR_FULL_NM() {
		return CTGR_FULL_NM;
	}
	public void setCTGR_FULL_NM(String cTGR_FULL_NM) {
		CTGR_FULL_NM = cTGR_FULL_NM;
	}
	public String getBID_MNMT_NO() {
		return BID_MNMT_NO;
	}
	public void setBID_MNMT_NO(String bID_MNMT_NO) {
		BID_MNMT_NO = bID_MNMT_NO;
	}
	public String getCLTR_NM() {
		return CLTR_NM;
	}
	public void setCLTR_NM(String cLTR_NM) {
		CLTR_NM = cLTR_NM;
	}
	public String getCLTR_MNMT_NO() {
		return CLTR_MNMT_NO;
	}
	public void setCLTR_MNMT_NO(String cLTR_MNMT_NO) {
		CLTR_MNMT_NO = cLTR_MNMT_NO;
	}
	public String getLDNM_ADRS() {
		return LDNM_ADRS;
	}
	public void setLDNM_ADRS(String lDNM_ADRS) {
		LDNM_ADRS = lDNM_ADRS;
	}
	public String getNMRD_ADRS() {
		return NMRD_ADRS;
	}
	public void setNMRD_ADRS(String nMRD_ADRS) {
		NMRD_ADRS = nMRD_ADRS;
	}
	public String getLDNM_PNU() {
		return LDNM_PNU;
	}
	public void setLDNM_PNU(String lDNM_PNU) {
		LDNM_PNU = lDNM_PNU;
	}
	public String getDPSL_MTD_CD() {
		return DPSL_MTD_CD;
	}
	public void setDPSL_MTD_CD(String dPSL_MTD_CD) {
		DPSL_MTD_CD = dPSL_MTD_CD;
	}
	public String getDPSL_MTD_NM() {
		return DPSL_MTD_NM;
	}
	public void setDPSL_MTD_NM(String dPSL_MTD_NM) {
		DPSL_MTD_NM = dPSL_MTD_NM;
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
	public String getIQRY_CNT() {
		return IQRY_CNT;
	}
	public void setIQRY_CNT(String iQRY_CNT) {
		IQRY_CNT = iQRY_CNT;
	}
	public String getGOODS_NM() {
		return GOODS_NM;
	}
	public void setGOODS_NM(String gOODS_NM) {
		GOODS_NM = gOODS_NM;
	}
	
	
	
}
