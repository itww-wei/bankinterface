package com.htmic.bankinterface.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.htmic.bankinterface.dao.IProjectBankDao;
import com.htmic.bankinterface.model.ProjectBank;
import com.htmic.bankinterface.service.IProjectBankService;
import com.htmic.bankinterface.utils.PageDto;
import com.htmic.bankinterface.utils.StringUtil;

/**
 * Created by wei on 2017/3/20.
 */
@Service
public class ProjectBankServiceImpl implements IProjectBankService{

	@Resource
	private IProjectBankDao projectBankDao;
	
	public List<ProjectBank> findAll(final ProjectBank project,PageDto page) {
		List<ProjectBank> result =new ArrayList<>();
		if(page==null){
			result = projectBankDao.findAll(new Specification<ProjectBank>() {
				@Override
				public Predicate toPredicate(Root<ProjectBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (project!=null) {
						if(project.getId()!=null){
							list.add(cb.like(root.get("id").as(String.class), "%" + project.getId() + "%"));
						}
					}
					Predicate[] p = new Predicate[list.size()];
					return cb.and(list.toArray(p));
				}
			});
		}else{
			//多条件查询+分页+排序
			Page<ProjectBank> pageRes = projectBankDao.findAll(new Specification<ProjectBank>() {
				@Override
				public Predicate toPredicate(Root<ProjectBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (project!=null) {
						if(project.getId()!=null){
							list.add(cb.like(root.get("id").as(String.class), "%" + project.getId() + "%"));
						}
						if(!StringUtil.isEmpty(project.getProjectNo())){
							list.add(cb.like(root.get("projectNo").as(String.class), "%" + project.getProjectNo() + "%"));
						}
					}
					Predicate[] p = new Predicate[list.size()];
		            return cb.and(list.toArray(p));
				}
			}, new PageRequest(page.getPage()-1, page.getLimit(),new Sort(Direction.DESC, "createTime")));
			
			//组装分页信息
			page.setTotal((int) pageRes.getTotalElements());
			page.setData(pageRes.getContent());
		}
		return result;
	}

	@Override
	public ProjectBank save(ProjectBank project) {
		return projectBankDao.save(project);
	}

	@Override
	public ProjectBank findOne(String id) {
		return projectBankDao.findOne(id);
	}

	@Override
	public ProjectBank findByProjectNo(String projectNo) {
		return projectBankDao.findByProjectNo(projectNo);
	}
	
}
