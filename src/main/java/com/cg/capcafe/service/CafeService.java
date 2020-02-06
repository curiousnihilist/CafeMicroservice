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
	
	/**
	 * Method for searching cafe using cafe id.
	 * @param cafeId
	 * @return Cafe
	 * @throws CafeNotFoundException
	 */
	Cafe searchById(int cafeId) throws CafeNotFoundException;
	
	/**
	 * Method for adding new Cafe to the table.
	 * @param Cafe
	 * @return Cafe
	 */
	Cafe addCafe(Cafe cafe);
	
	/**
	 * Method for updating existing cafe in the table.
	 * @param cafe
	 * @return
	 */
	Cafe updateCafe(Cafe cafe);
	
	/**
	 * Method for deleting cafe details using cafeId
	 * @param cafeId
	 * @return boolean
	 * @throws CafeNotFoundException
	 */
	boolean deleteCafe(int cafeId) throws CafeNotFoundException;
	
	/**
	 * Method for searching cafe's in a given price range.
	 * @param min price
	 * @param max price
	 * @return List of cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchByPricing(int min, int max) throws CafeNotFoundException;
	
	/**
	 * Method for searching cafe's in a given range of ratings.
	 * @param min rating
	 * @param max rating
	 * @return List of Cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchByRatings(double min, double max) throws CafeNotFoundException; 
	
	/**
	 * Method for fetching all the cafe.
	 * @return List of cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> getAllCafe() throws CafeNotFoundException;
	
	/**
	 * Method for searching cafe based on name
	 * @param name
	 * @return List of Cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchByName(String name) throws CafeNotFoundException;
	
	/**
	 * Method for searching cafe based on location.
	 * @param location
	 * @return List of Cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchByLocation(String location) throws CafeNotFoundException;
	
	/**
	 * Method for searching cafe based on dish. 
	 * @param foodItem
	 * @return List of cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchByMenu(String foodItem) throws CafeNotFoundException;
	
	/**
	 * Method for searching food for customer by location and cafe name
	 * @param location
	 * @param name
	 * @return List of cafe
	 * @throws CafeNotFoundException
	 */
	List<Cafe> searchFood(String location, String name) throws CafeNotFoundException;

}
