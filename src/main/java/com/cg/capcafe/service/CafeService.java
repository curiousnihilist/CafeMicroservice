package com.cg.capcafe.service;

import java.util.List;


import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.exception.CafeNotFoundException;

/**
 * Cafe Service Interface which contains all abstract service methods for cafe's.
 * @author Akash Verma
 *
 */
public interface CafeService {
	
	Cafe searchById(int cafeId) throws CafeNotFoundException;
	Cafe addCafe(Cafe cafe);
	Cafe updateCafe(Cafe cafe);
	boolean deleteCafe(int cafeId) throws CafeNotFoundException;
	
	List<Cafe> searchByPricing(double min, double max) throws CafeNotFoundException;
	List<Cafe> searchByRatings(int min, int max) throws CafeNotFoundException; 
	List<Cafe> getAllCafe() throws CafeNotFoundException;
	List<Cafe> searchByName(String name) throws CafeNotFoundException;
	List<Cafe> searchByLocation(String location) throws CafeNotFoundException;
	List<Cafe> searchByMenu(String foodItem) throws CafeNotFoundException;
	

}
