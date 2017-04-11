package com.htmic.bankinterface.service;

import java.util.List;

import com.htmic.bankinterface.model.ProjectBank;
import com.htmic.bankinterface.utils.PageDto;


public interface IProjectBankService {
	
	List<ProjectBank> findAll(ProjectBank project,PageDto page);
	
	ProjectBank save(ProjectBank project);
	
	ProjectBank findOne(String id);

	ProjectBank findByProjectNo(String projectNo);
}
