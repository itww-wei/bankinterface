package com.htmic.bankinterface.service;

import java.util.List;

import com.htmic.bankinterface.model.PayBank;
import com.htmic.bankinterface.utils.PageDto;

public interface IPayBankService {
	/**
	 * 查询入账明细(缴纳信息)
	 * @param pay
	 * @param page
	 * @return
	 */
	List<PayBank> findAll(PayBank pay, PageDto page);

	PayBank save(PayBank pay);
	
	PayBank findOne(String id);
	
	PayBank findByHstSeqNum(String hstSeqNum);

	/**
	 * 获取该项目的保证金退款信息
	 * @param pay
	 * @param page
	 * @return
	 */
	List<PayBank> findReturnPayBank(PayBank pay, PageDto page);
}
