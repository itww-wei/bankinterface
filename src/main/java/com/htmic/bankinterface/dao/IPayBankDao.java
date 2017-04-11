package com.htmic.bankinterface.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htmic.bankinterface.model.PayBank;

@Repository
public interface IPayBankDao extends JpaRepository<PayBank, String>,JpaSpecificationExecutor<PayBank>{

	@Query("select pay from PayBank pay where pay.hstSeqNum=:hstSeqNum")
	PayBank findByHstSeqNum(@Param("hstSeqNum")String hstSeqNum);

}
