package com.htmic.bankinterface.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.htmic.bankinterface.model.ProjectBank;

/**
 * Created by wei on 2017/3/20.
 */
@Repository
public interface IProjectBankDao extends JpaRepository<ProjectBank, String>, JpaSpecificationExecutor<ProjectBank> {

	@Query("select pb from ProjectBank pb where pb.projectNo=:projectNo")
	ProjectBank findByProjectNo(@Param("projectNo")String projectNo);
	
//	@Query("select u from ProjectBank u where u.userName=:userName and u.passWord=:passWord")
//  public ProjectBank findUserByNameAndPwd(@Param("userName") String useName,@Param("passWord") String passWord);
}
