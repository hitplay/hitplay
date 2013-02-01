package org.hitplay.misc;

import java.io.Serializable;

public class PaginationHelper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8101282636150764953L;
	
	private int per_page;
	private int current_page;
	private int total_count;
	
	private int number_of_pages;
	
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	public int getNumber_of_pages() {
		return number_of_pages;
	}
	public void setNumber_of_pages() {
		this.number_of_pages = (this.total_count / this.per_page);
	}

}