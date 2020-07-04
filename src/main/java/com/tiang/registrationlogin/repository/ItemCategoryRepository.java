package com.tiang.registrationlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiang.registrationlogin.model.ItemCategory;

@Repository
public interface ItemCategoryRepository extends CrudRepository<ItemCategory, Long> {
	//find by user id
 List<ItemCategory> findByCatUserId(long catUserId);
	List<ItemCategory>findAll();
	List<ItemCategory> deleteByCatId(long catId);
	ItemCategory findByCatId(long catId);
	
}
