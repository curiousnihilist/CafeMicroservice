package com.cg.capcafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.exception.FoodItemNotFoundException;
import com.cg.capcafe.repo.MenuRepository;
import com.cg.capcafe.service.MenuService;

/**
 * Rest controller class containing rest end points for accessing menu resources.
 * @author Akash Verma
 *
 */
@RestController
@RequestMapping(value = "/menu")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * Post mapping method to add new dish.
	 * @param FoodItem
	 * @return FoodItem
	 */
	@PostMapping(value = "/add-item")
	public FoodItem addDish(@RequestBody FoodItem foodItem) {
		return menuService.persistItem(foodItem);
	}
	
	/**
	 * Put mapping method for updating existing dish details.
	 * @param foodItem
	 * @return FoodItem
	 */
	@PutMapping(value = "/update-item")
	public FoodItem updateDish(@RequestBody FoodItem foodItem) {
		return menuService.updateItem(foodItem);
	}
	
	/**
	 * Delete mapping method for deleting existing dish by itemId	
	 * @param itemId
	 * @return itemId (Integer)
	 * @throws FoodItemNotFoundException
	 */
	@DeleteMapping(value = "/delete-item")
	public int deleteDish(@RequestParam int itemId) throws FoodItemNotFoundException{
		if(menuService.deleteItem(itemId))
			return itemId;
		else
			return 0;
	}
	
	/**
	 * Delete mapping method for fetching dish by itemId
	 * @param itemId
	 * @return FoodItem
	 * @throws FoodItemNotFoundException
	 */
	@GetMapping(value = "/get-dish-by-id")
	public FoodItem getDishById(@RequestParam int itemId) throws FoodItemNotFoundException{
		return menuService.getItemById(itemId);
	}
	
	/**
	 * Get mapping method for fetching all existing dishes
	 * @return
	 * @throws FoodItemNotFoundException
	 */
	@GetMapping(value = "/get-all-dishes")
	public List<FoodItem> getAllDishes() throws FoodItemNotFoundException{
		return menuService.getAllItems();
	}
	
	
	

}
