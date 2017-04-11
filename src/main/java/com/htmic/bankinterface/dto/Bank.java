package com.htmic.bankinterface.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bank {
	@JsonProperty(value = "InName")  
	private String inName;
	
	@JsonProperty(value = "PunInst")  //投标人退款利息
	private String punInst;

	@JsonProperty(value = "InAmount")  //到账金额
	private String inAmount;
	
	@JsonProperty(value = "InTime")  //到账时间
	private String inTime;
	
	@JsonProperty(value = "Gernal") //是否基本户 
	private String gernal;
	
	@JsonProperty(value = "InMemo")  //收款账号
	private String inMemo;
	
	@JsonProperty(value = "InAcct")  //付款人账号
	private String inAcct;
	
	@JsonProperty(value = "InDate")  //到账日期
	private String inDate;
	
	@JsonProperty(value = "HstSeqNum")  //交易流水号
	private String hstSeqNum;
	
	@JsonProperty(value = "Result")  //是否退款
	private String result;
	
	@JsonProperty(value = "InAcctNo")  //转入账号
	private String inAcctNo;
	
	@JsonProperty(value = "AddWord")  //退款说明
	private String addWord;
	
	@JsonProperty(value = "BjPunInst")  //与招投标中心协定利率的利息
	private String bjPunInst;
	
	

	public String getBjPunInst() {
		return bjPunInst;
	}

	public void setBjPunInst(String bjPunInst) {
		this.bjPunInst = bjPunInst;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public String getPunInst() {
		return punInst;
	}

	public void setPunInst(String punInst) {
		this.punInst = punInst;
	}

	public String getInAmount() {
		return inAmount;
	}

	public void setInAmount(String inAmount) {
		this.inAmount = inAmount;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getGernal() {
		return gernal;
	}

	public void setGernal(String gernal) {
		this.gernal = gernal;
	}

	public String getInMemo() {
		return inMemo;
	}

	public void setInMemo(String inMemo) {
		this.inMemo = inMemo;
	}

	public String getInAcct() {
		return inAcct;
	}

	public void setInAcct(String inAcct) {
		this.inAcct = inAcct;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getHstSeqNum() {
		return hstSeqNum;
	}

	public void setHstSeqNum(String hstSeqNum) {
		this.hstSeqNum = hstSeqNum;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInAcctNo() {
		return inAcctNo;
	}

	public void setInAcctNo(String inAcctNo) {
		this.inAcctNo = inAcctNo;
	}

	public String getAddWord() {
		return addWord;
	}

	public void setAddWord(String addWord) {
		this.addWord = addWord;
	}

	@Override
	public String toString() {
		return "Bank [inName=" + inName + ", punInst=" + punInst + ", inAmount=" + inAmount + ", inTime=" + inTime
				+ ", gernal=" + gernal + ", inMemo=" + inMemo + ", inAcct=" + inAcct + ", inDate=" + inDate
				+ ", hstSeqNum=" + hstSeqNum + ", result=" + result + ", inAcctNo=" + inAcctNo + ", addWord=" + addWord
				+ ", bjPunInst=" + bjPunInst + "]";
	}

	
}
