package com.yc.ums.entity;

import java.util.List;

public class ProfileBean {
	//分页接收参数
	private Integer pageSize;
	private Integer currPage;
	//响应给页面的
	private Integer total;
	private List<Profile> rows;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Profile> getRows() {
		return rows;
	}
	public void setRows(List<Profile> rows) {
		this.rows = rows;
	}
	public ProfileBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProfileBean(Integer pageSize, Integer currPage) {
		super();
		this.pageSize = pageSize;
		this.currPage = currPage;
	}
	@Override
	public String toString() {
		return "ProfileBean [pageSize=" + pageSize + ", currPage=" + currPage
				+ ", total=" + total + ", rows=" + rows + "]";
	}
	
}
