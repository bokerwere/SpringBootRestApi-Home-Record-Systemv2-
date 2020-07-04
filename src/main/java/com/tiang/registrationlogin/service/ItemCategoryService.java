package com.tiang.registrationlogin.service;

import java.util.List;

import com.tiang.registrationlogin.model.ItemCategory;

public interface ItemCategoryService {
	public ItemCategory  addItemCategory( ItemCategory itemCategory);
	
 List<ItemCategory>  getItemCategory();
 List<ItemCategory>  getItemCategoryList();
 public void deleteItem(long catId);
 ItemCategory findCategoryId(long id );

}
