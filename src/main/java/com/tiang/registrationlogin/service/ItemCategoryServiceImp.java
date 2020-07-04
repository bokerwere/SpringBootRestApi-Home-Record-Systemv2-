package com.tiang.registrationlogin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiang.registrationlogin.model.ItemCategory;
import com.tiang.registrationlogin.repository.ItemCategoryRepository;

@Service
@Transactional
@Scope(proxyMode =ScopedProxyMode.INTERFACES)
public class ItemCategoryServiceImp implements ItemCategoryService {

	@Autowired
	ItemCategoryRepository itemCategoryRepository;

	public ItemCategory addItemCategory(ItemCategory itemCategory) {

		return itemCategoryRepository.save(itemCategory);
		
		
	}

	@Override
	public List<ItemCategory> getItemCategory() {
		// TODO Auto-generated method stub
		//return itemCategoryRepository.findByCatUserId(1);

		// return (List<ItemCategory>) itemCategoryRepository.findAll();
		return itemCategoryRepository.findAll();

	}

	@Override
	public List<ItemCategory> getItemCategoryList() {
		return itemCategoryRepository.findAll();
	}

	
	public void deleteItem(long catId) {
		itemCategoryRepository.deleteByCatId(catId);

	}

	@Override
	public ItemCategory findCategoryId(long id) {
		
		 Optional<ItemCategory> option	=Optional.of(itemCategoryRepository.findByCatId(id));
		 ItemCategory item=null;
		 if(option.isPresent()) {
			 item=option.get();
		 }else {
			 
			 throw new RuntimeException("item not found id:: " +id);
			 
		 }
		 return item;
	
	}
}