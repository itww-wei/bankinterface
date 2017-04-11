package com.htmic.bankinterface.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Body {

	@JsonProperty(value = "bank")  
	private List<Bank> bank;
	
	@JsonProperty(value = "BanK")  
	private List<Bank> returnDepositBank;
	
	@JsonProperty(value = "Result")  
	private String result;
	
	@JsonProperty(value = "AddWord")  
	private String addWord;
	
	@JsonProperty(value = "IsPay")  
	private String isPay;
	
	@JsonProperty(value = "InTime")  
	private String inTime;
	
	@JsonProperty(value = "InAmount")  
	private String inAmount;
	
	@JsonProperty(value = "InName")  
	private String inName;
	
	@JsonProperty(value = "InAcct")  
	private String inAcct;
	
	@JsonProperty(value = "InMemo")  
	private String inMemo;
	
	@JsonProperty(value = "HstSeqNum")  
	private String hstSeqNum;
	
	@JsonProperty(value = "PunInst")  
	private String punInst;
	
	@JsonProperty(value = "Gernal")  
	private String gernal;

	
	//============
	@JsonProperty(value = "ItemNo")  
	private String itemNo;

	@JsonProperty(value = "ItemNox")  
	private String itemNox;

	@JsonProperty(value = "AccNo")  
	private String accNo;

	@JsonProperty(value = "AccName")  
	private String accName;

	@JsonProperty(value = "AuthCode")  
	private String authCode;
	
	@JsonProperty(value = "TransRltMsg")  
	private String transRltMsg;
	
	@JsonProperty(value = "IAcctNo")  
	private String iAcctNo;
	
	@JsonProperty(value = "TransCode")  
	private String transCode;

	public List<Bank> getBank() {
		return bank;
	}

	public void setBank(List<Bank> bank) {
		this.bank = bank;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAddWord() {
		return addWord;
	}

	public void setAddWord(String addWord) {
		this.addWord = addWord;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getInAmount() {
		return inAmount;
	}

	public void setInAmount(String inAmount) {
		this.inAmount = inAmount;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public String getInAcct() {
		return inAcct;
	}

	public void setInAcct(String inAcct) {
		this.inAcct = inAcct;
	}

	public String getInMemo() {
		return inMemo;
	}

	public void setInMemo(String inMemo) {
		this.inMemo = inMemo;
	}

	public String getHstSeqNum() {
		return hstSeqNum;
	}

	public void setHstSeqNum(String hstSeqNum) {
		this.hstSeqNum = hstSeqNum;
	}

	public String getPunInst() {
		return punInst;
	}

	public void setPunInst(String punInst) {
		this.punInst = punInst;
	}

	public String getGernal() {
		return gernal;
	}

	public void setGernal(String gernal) {
		this.gernal = gernal;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemNox() {
		return itemNox;
	}

	public void setItemNox(String itemNox) {
		this.itemNox = itemNox;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getTransRltMsg() {
		return transRltMsg;
	}

	public void setTransRltMsg(String transRltMsg) {
		this.transRltMsg = transRltMsg;
	}

	public String getiAcctNo() {
		return iAcctNo;
	}

	public void setiAcctNo(String iAcctNo) {
		this.iAcctNo = iAcctNo;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public List<Bank> getReturnDepositBank() {
		return returnDepositBank;
	}

	public void setReturnDepositBank(List<Bank> returnDepositBank) {
		this.returnDepositBank = returnDepositBank;
	}
	
	
}
