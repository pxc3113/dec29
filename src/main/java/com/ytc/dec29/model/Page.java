package com.ytc.dec29.model;

import java.util.ArrayList;
import java.util.List;


public class Page{

	private int start; // 起始条数
	private int end; // 结束条数
	private int totalPage; // 总页数
	private int currentPage=1; // 当前页
	private int totalRowNum=200; // 总信息数
	private int pageSize = 10; // 每页条数
	private List<? extends Object> list = new ArrayList<>();  //当前页的数据
	
	public Page(int currentPage, int totalRowNum, int pageSize) {
		this.totalRowNum = totalRowNum;
		this.pageSize = pageSize;
		this.currentPage = (currentPage <= 0) ? 1 : currentPage;
		this.totalPage = (int) (totalRowNum / pageSize) + 1;
		if (this.currentPage > this.totalPage)
			this.currentPage = this.totalPage;
		if(this.currentPage - 1==-1){//判断当前页是否为0 如果当前页为0把开始位置置为0
			this.start =0;
		}else{
			this.start = (this.currentPage - 1) * pageSize;
		}
		this.end = this.start + pageSize;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalRowNum() {
		return totalRowNum;
	}

	public int getPageSize() {
		return pageSize;
	}


	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalRowNum(Long totalRowNum) {
		this.totalPage = (int) (totalRowNum / pageSize);
		if (totalRowNum % pageSize > 0)
			this.totalPage = this.totalPage + 1;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setList(List<? extends Object> list) {
		this.list = list;
	}

	public List<? extends Object> getList() {
		return list;
	}

}
