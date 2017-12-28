package com.snowfish.domain;

import java.util.List;

public class PageBean <T>{
	private int currentPage; //当前页
	private int totlePage;//总页数
	private int totleRecoder;//总记录数
	private int recoderForPage;//一页显示的记录数
	private List<Student> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotlePage() {
		int i=totleRecoder%recoderForPage;
		return i==0?totleRecoder/recoderForPage:(totleRecoder/recoderForPage)+1;
	}
//	public void setTotlePage(int totlePage) {
//		this.totlePage = totlePage;
//	}
	public int getTotleRecoder() {
		return totleRecoder;
	}
	public void setTotleRecoder(int totleRecoder) {
		this.totleRecoder = totleRecoder;
	}
	public int getRecoderForPage() {
		return recoderForPage;
	}
	public void setRecoderForPage(int recoderForPage) {
		this.recoderForPage = recoderForPage;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}


}
