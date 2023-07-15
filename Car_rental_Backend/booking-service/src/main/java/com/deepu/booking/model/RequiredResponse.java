package com.deepu.booking.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class RequiredResponse {
	

	@Id
	private List<Cart> l1;
	private Integer bid;
	private Integer uid;
	private Double finalprice;
	public List<Cart> getL1() {
		return l1;
	}
	public void setL1(List<Cart> l1) {
		this.l1 = l1;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Double getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(Double finalprice) {
		this.finalprice = finalprice;
	}
	@Override
	public String toString() {
		return "RequiredResponse [l1=" + l1 + ", bid=" + bid + ", uid=" + uid + ", finalprice=" + finalprice + "]";
	}
	
	
	
}
