package com.tiang.registrationlogin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="Items")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	long id;
	@Column(name="item_name")
	String itemName;
	@Column(name="item_category")
	String itemCategory ;
	@Column(name="item_description")
	String itemDescription;
	@Column(name="item_price")
     Float  itemPrice;
	
	 @Column(name="Date")
	 String date;
	@Column(name="created_date")
     Date createdAt;
	@Column(name="update_date")
     Date updateAt;
	@PrePersist
	public void Oncreated() {createdAt	=new Date();}
	@PreUpdate
	public void UpdatedOn() {updateAt=new Date(); }
	
	public Items() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Items(long id, String itemName, String itemCategory, String itemDescription, Float itemPrice, String date,
			Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.date = date;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemDescription="
				+ itemDescription + ", itemPrice=" + itemPrice + ", date=" + date + ", createdAt=" + createdAt
				+ ", updateAt=" + updateAt + "]";
	}
	
	
}
