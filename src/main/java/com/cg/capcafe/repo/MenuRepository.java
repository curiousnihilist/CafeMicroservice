package com.cg.capcafe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.FoodItem;

@Repository
public interface MenuRepository extends JpaRepository<FoodItem, Integer> {
	

}
