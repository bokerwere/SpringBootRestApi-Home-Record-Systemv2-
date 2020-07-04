package com.tiang.registrationlogin.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiang.registrationlogin.model.Items;

@Repository
public interface ItemsRepository  extends JpaRepository<Items, Long>{
	
	
//Optional<Items> findById(Long id);
}
