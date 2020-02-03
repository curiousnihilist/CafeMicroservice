package com.cg.capcafe.service;

import java.util.List;

import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.exception.FoodItemNotFoundException;

/**
 * Menu Service Interface which contains all abstract service methods for menu in cafe's.
 * @author Akash Verma
 *
 */
public interface MenuService {
	
	FoodItem getItemById(int itemId) throws FoodItemNotFoundException;
	FoodItem persistItem(FoodItem foodItem);
	FoodItem updateItem(FoodItem foodItem);
	boolean deleteItem(int itemId) throws FoodItemNotFoundException;
	
	List<FoodItem> getAllItems() throws FoodItemNotFoundException;

}
