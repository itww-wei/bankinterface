package com.htmic.bankinterface.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by wei on 2017/3/20.
 * 数据库保证金缴纳信息表
 */
@Entity
@Table(name = "T_PAY_BANK")
public class PayBank {
	
	public PayBank() {
	}
	
	public PayBank(String projectBankId) {
		this.projectBankId = projectBankId;
	}

	public PayBank(Integer result) {
		this.projectBankId = System.currentTimeMillis()+"";
		this.projectId = System.currentTimeMillis()+"";
		this.inName = "户名"+System.currentTimeMillis()+"";
		this.inAmount = 666D;
		this.inDate = new Date();
		this.inAcct = System.currentTimeMillis()+"";
		this.hstSeqNum = System.currentTimeMillis()+"";
		this.result = 0;
		this.addWord = "提示语";
	}

	@Id
	@GeneratedValue(generator = "UIDGenerator")
	@GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;
    
    @Column(name = "PROJECTBANKID")
    private String projectBankId;//项目账号信息id

    @Column(name = "PROJECTID")
    private String projectId;//项目id

    @Column(name = "INNAME")
    private String inName;//账号户名

//    @Column(name = "punInst")
//    private String punInst;////投标人退款利息

    @Column(name = "INAMOUNT")
    private Double inAmount;//到账金额

    @Column(name="INDATE")
    private Date inDate;//到账时间(缴费时间)
    
//    @Column(name = "INTIME")
//    private Date inTime;  //到账时间

//    @Column(name = "gernal")
//    private String gernal;//是否基本户

//    @Column(name="inMemo")
//    private String inMemo;//收款账号

    @Column(name="INACCT")
    private String inAcct;//付款人账号

    @Column(name="HSTSEQNUM")
    private String hstSeqNum;//交易流水号

    @Column(name="RESULT")
    private Integer result=0;//是否退款

//    @Column(name="inAcctNo")
//    private String inAcctNo;//转入账号

    @Column(name="ADDWORD")
    private String addWord="无";//退款说明

//    @Column(name="bjPunInst")
//    private String bjPunInst;//与招投标中心协定利率的利息

    @Column(name="ISRETURN")
    private Integer isReturn=0;//是否退款申请0：未申请 ，1：已申请，2：已退款
    
    @Column(name="REFUNDDATE")
    private Date refundDate=new Date();//退款时间
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectBankId() {
		return projectBankId;
	}

	public void setProjectBankId(String projectBankId) {
		this.projectBankId = projectBankId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public Double getInAmount() {
		return inAmount;
	}

	public void setInAmount(Double inAmount) {
		this.inAmount = inAmount;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public String getInAcct() {
		return inAcct;
	}

	public void setInAcct(String inAcct) {
		this.inAcct = inAcct;
	}

	public String getHstSeqNum() {
		return hstSeqNum;
	}

	public void setHstSeqNum(String hstSeqNum) {
		this.hstSeqNum = hstSeqNum;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getAddWord() {
		return addWord;
	}

	public void setAddWord(String addWord) {
		this.addWord = addWord;
	}
	
	public Integer getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(Integer isReturn) {
		this.isReturn = isReturn;
	}
	
	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	
	@Override
	public String toString() {
		return "PayBank [id=" + id + ", projectBankId=" + projectBankId
				+ ", projectId=" + projectId + ", inName=" + inName
				+ ", inAmount=" + inAmount + ", inDate=" + inDate + ", inAcct="
				+ inAcct + ", hstSeqNum=" + hstSeqNum + ", result=" + result
				+ ", addWord=" + addWord + "]";
	}

}
