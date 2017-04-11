package com.htmic.bankinterface.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Head {
	//{"SeqNo":"******","TransCode":"******","TransTime":"******","TransDate":"*******"}
	@JsonProperty(value = "SeqNo")  
	private String seqNo;
	
	@JsonProperty(value = "TransCode")  
	private String transCode;
	
	@JsonProperty(value = "TransTime")  
	private String transTime;
	
	@JsonProperty(value = "TransDate")  
	private String transDate;
	
	@JsonProperty(value = "IAcctNo")  
	private String iAcctNo;
	
	@JsonProperty(value = "AuthCode")  
	private String authCode;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getiAcctNo() {
		return iAcctNo;
	}

	public void setiAcctNo(String iAcctNo) {
		this.iAcctNo = iAcctNo;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	
}
