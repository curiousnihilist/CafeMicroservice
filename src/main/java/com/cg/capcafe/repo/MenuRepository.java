package com.cg.capcafe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capcafe.dto.FoodItem;

public interface MenuRepository extends JpaRepository<FoodItem, Integer> {
	

}
