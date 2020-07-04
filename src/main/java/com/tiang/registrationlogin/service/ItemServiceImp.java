package com.tiang.registrationlogin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiang.registrationlogin.model.Items;
import com.tiang.registrationlogin.repository.ItemsRepository;
@Service
public class ItemServiceImp implements ItemService {
	

@Autowired
	ItemsRepository itemsRepository;
	@Override
	//Display  items
	public List<Items> getAllItem() {
		
		
	return itemsRepository.findAll();
	}

	@Override
	public Items SaveItem( Items  item)  {
		
		return itemsRepository.save(item );
	}

	@Override
	public Items findItemId(long id) {
		 Optional<Items> option=itemsRepository.findById(id);
		 Items item=null;
		 if(option.isPresent()) {
			 item=option.get();
		 }else {
			 
			 throw new RuntimeException("item not found id:: " +id);
		 }
		 
 
		return item;
	}

	@Override
	public void deleteById(long id) {
	  itemsRepository.deleteById(id);
		
	}




}
