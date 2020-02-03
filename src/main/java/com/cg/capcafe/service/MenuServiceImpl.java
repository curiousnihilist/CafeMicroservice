package com.cg.capcafe.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.exception.FoodItemNotFoundException;
import com.cg.capcafe.repo.MenuRepository;

/**
 * Implememtation for MenuService interface. It contains business logics for Menu service.
 * @author Akash Verma
 *
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepo;

	@Override
	public FoodItem persistItem(FoodItem foodItem) {
		return menuRepo.save(foodItem);
	}

	@Override
	public FoodItem updateItem(FoodItem foodItem) {
		return menuRepo.save(foodItem);
	}
	
	@Override
	public FoodItem getItemById(int itemId) throws FoodItemNotFoundException {
		Optional<FoodItem> item = menuRepo.findById(itemId);
		if(item.isEmpty())
			throw new FoodItemNotFoundException("No item present with id: "+itemId);
		return item.get();
	}
	
	@Override
	public boolean deleteItem(int itemId) throws FoodItemNotFoundException {
		try {
			menuRepo.deleteById(itemId);
			return true;
		} catch(Exception e) {
			throw new FoodItemNotFoundException("No item found with id: "+itemId);
		}
	}

	@Override
	public List<FoodItem> getAllItems() throws FoodItemNotFoundException {
		List<FoodItem> items = menuRepo.findAll();
		if(items.isEmpty())
			throw new FoodItemNotFoundException("No items present!");
		return items;
	}

	

}
