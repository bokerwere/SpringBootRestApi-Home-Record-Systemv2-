package com.tiang.registrationlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemCategory")
public class ItemCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	Long catId;
	@Column(name = "category_type")
	String catType;
	@Column(name = "user_id")
	Long catUserId;
	
	
	public ItemCategory(Long catId, String catType, Long catUserId) {
		super();
		this.catId = catId;
		this.catType = catType;
		this.catUserId = catUserId;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatType() {
		return catType;
	}
	public void setCatType(String catType) {
		this.catType = catType;
	}
	public Long getCatUserId() {
		return catUserId;
	}
	public void setCatUserId(Long catUserId) {
		this.catUserId = catUserId;
	}
	public ItemCategory() {
		
	}
	@Override
	public String toString() {
		return "ItemCategory [catId=" + catId + ", catType=" + catType + ", catUserId=" + catUserId + "]";
	}
	

}
