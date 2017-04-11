package com.htmic.bankinterface.utils;

import java.util.List;

/**
 * jquery.datatable 分页数据封装类
 * @author wei
 *
 */
public class Page<T> {
	private Integer sEcho=0;//当前页(默认为0)
	private Integer iTotalDisplayRecords;//总显示记录(总条数)
	private Integer iDisplayLength;//每页条数
	
	private Integer iTotalRecords;//全记录
	private List<T> data;
	
//	private Map<String, Object> map;
	
	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setIDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setITotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setITotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getsEcho() {
		return sEcho;
	}

	public void setSEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	@Override
	public String toString() {
		return "Page [sEcho=" + sEcho + ", iTotalDisplayRecords="
				+ iTotalDisplayRecords + ", iDisplayLength=" + iDisplayLength
				+ ", iTotalRecords=" + iTotalRecords + "]";
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}


}
