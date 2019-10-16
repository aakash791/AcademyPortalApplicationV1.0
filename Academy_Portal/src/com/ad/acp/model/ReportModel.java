package com.ad.acp.model;

public class ReportModel {

	String batid;
	String facid;
	int weekRep;
	int mockTest;
	String bhsRep;
	String innTitle;
	String proDesc;
	String proStatus;
	int points;
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getBatid() {
		return batid;
	}
	public void setBatid(String batid) {
		this.batid = batid;
	}
	public String getFacid() {
		return facid;
	}
	public void setFacid(String facid) {
		this.facid = facid;
	}
	public int getWeekRep() {
		return weekRep;
	}
	public void setWeekRep(int weekRep) {
		this.weekRep = weekRep;
	}
	public int getMockTest() {
		return mockTest;
	}
	public void setMockTest(int mockTest) {
		this.mockTest = mockTest;
	}
	public String getBhsRep() {
		return bhsRep;
	}
	public void setBhsRep(String bhsRep) {
		this.bhsRep = bhsRep;
	}
	public String getInnTitle() {
		return innTitle;
	}
	public void setInnTitle(String innTitle) {
		this.innTitle = innTitle;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProStatus() {
		return proStatus;
	}
	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}

}
