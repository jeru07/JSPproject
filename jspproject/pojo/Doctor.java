package com.chainsys.jspproject.pojo;
import java.util.Date;
public class Doctor 
{
	private int DOC_ID;  
	private String DOC_NAME; 
	private Date DOB;         
	private String SPECIALITY; 
	private String CITY; 
	private long PHONE_NO;   
	private float FEES;
	public int getDOC_ID() {
		return DOC_ID;
	}
	public void setDOC_ID(int dOC_ID) {
		DOC_ID = dOC_ID;
	}
	public String getDOC_NAME() {
		return DOC_NAME;
	}
	public void setDOC_NAME(String dOC_NAME) {
		DOC_NAME = dOC_NAME;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getSPECIALITY() {
		return SPECIALITY;
	}
	public void setSPECIALITY(String sPECIALITY) {
		SPECIALITY = sPECIALITY;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public long getPHONE_NO() {
		return PHONE_NO;
	}
	public void setPHONE_NO(long pHONE_NO) {
		PHONE_NO = pHONE_NO;
	}
	public float getFEES() {
		return FEES;
	}
	public void setFEES(float fEES) {
		FEES = fEES;
	}
	
}