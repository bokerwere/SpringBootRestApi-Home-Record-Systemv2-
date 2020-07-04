package com.tiang.registrationlogin.service;

import java.util.List;

import com.tiang.registrationlogin.model.Items;

public interface ItemService {
	public List<Items> getAllItem();
	
	public Items SaveItem( Items items);
	public Items findItemId(long id);
	    void deleteById(long id);
	

}
