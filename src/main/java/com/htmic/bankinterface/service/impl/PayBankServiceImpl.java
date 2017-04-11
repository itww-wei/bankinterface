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

import com.htmic.bankinterface.dao.IPayBankDao;
import com.htmic.bankinterface.model.PayBank;
import com.htmic.bankinterface.service.IPayBankService;
import com.htmic.bankinterface.utils.PageDto;
import com.htmic.bankinterface.utils.StringUtil;

@Service
public class PayBankServiceImpl implements IPayBankService{

	@Resource
	private IPayBankDao payBankDao;
	
	@Override
	public List<PayBank> findAll(final PayBank pay, PageDto page) {
		List<PayBank> result =new ArrayList<>();
		if(page==null){
			result = payBankDao.findAll(new Specification<PayBank>() {
				@Override
				public Predicate toPredicate(Root<PayBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (pay!=null) {
						if(!StringUtil.isEmpty(pay.getInName())){
							list.add(cb.like(root.get("inName").as(String.class), "%" + pay.getInName() + "%"));
						}
						if(!StringUtil.isEmpty(pay.getProjectBankId())){
							list.add(cb.like(root.get("projectBankId").as(String.class),  pay.getProjectBankId()));
						}
					}
					Predicate[] p = new Predicate[list.size()];
					return cb.and(list.toArray(p));
				}
			});
		}else{
			//多条件查询+分页+排序
			Page<PayBank> pageRes = payBankDao.findAll(new Specification<PayBank>() {
				@Override
				public Predicate toPredicate(Root<PayBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (pay!=null) {
						if(!StringUtil.isEmpty(pay.getInName())){
							list.add(cb.like(root.get("inName").as(String.class), "%" + pay.getInName() + "%"));
						}
						if(!StringUtil.isEmpty(pay.getProjectBankId())){
							list.add(cb.like(root.get("projectBankId").as(String.class),  pay.getProjectBankId()));
						}
					}
					Predicate[] p = new Predicate[list.size()];
		            return cb.and(list.toArray(p));
				}
			}, new PageRequest(page.getPage()-1, page.getLimit(),new Sort(Direction.DESC, "inDate")));
			
			//组装分页信息
			page.setTotal((int) pageRes.getTotalElements());
			page.setData(pageRes.getContent());
		}
		return result;
	}

	@Override
	public PayBank save(PayBank pay) {
		return payBankDao.save(pay);
	}

	@Override
	public PayBank findOne(String id) {
		return payBankDao.findOne(id);
	}

	@Override
	public PayBank findByHstSeqNum(String hstSeqNum) {
		return payBankDao.findByHstSeqNum(hstSeqNum);
	}

	@Override
	public List<PayBank> findReturnPayBank(final PayBank pay, PageDto page) {
		List<PayBank> result =new ArrayList<>();
		if(page==null){
			result = payBankDao.findAll(new Specification<PayBank>() {
				@Override
				public Predicate toPredicate(Root<PayBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (pay!=null) {
						list.add(cb.in(root.get("isReturn").as(Integer.class)).value(1).value(2));//isReturn 查询 已退款和已申请 的
						list.add(cb.equal(root.get("projectBankId").as(String.class), pay.getProjectBankId()));
					}
					Predicate[] p = new Predicate[list.size()];
					return cb.and(list.toArray(p));
				}
			});
		}else{
			//多条件查询+分页+排序
			Page<PayBank> pageRes = payBankDao.findAll(new Specification<PayBank>() {
				@Override
				public Predicate toPredicate(Root<PayBank> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					if (pay!=null) {
						list.add(cb.in(root.get("isReturn").as(Integer.class)).value(1).value(2));//isReturn 查询 已退款和已申请 的
						list.add(cb.equal(root.get("projectBankId").as(String.class), pay.getProjectBankId()));
					}
					Predicate[] p = new Predicate[list.size()];
		            return cb.and(list.toArray(p));
				}
			}, new PageRequest(page.getPage()-1, page.getLimit(),new Sort(Direction.DESC, "inDate")));
			
			//组装分页信息
			page.setTotal((int) pageRes.getTotalElements());
			page.setData(pageRes.getContent());
		}
		return result;
	}
	
}
