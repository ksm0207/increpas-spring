package spring.movie.vo;

public class MovieVO {
	
	private String name;
	private String releasdate;
	private String company;
	private String screeningtime;
	
	public MovieVO(String name, String releasdate, String company, String screeningtime) {
		this.name=name;
		this.releasdate=releasdate;
		this.company=company;
		this.screeningtime=screeningtime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleasdate() {
		return releasdate;
	}
	public void setReleasdate(String releasdate) {
		this.releasdate = releasdate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getScreeningtime() {
		return screeningtime;
	}
	public void setScreeningtime(String screeningtime) {
		this.screeningtime = screeningtime;
	}
	
	

}
