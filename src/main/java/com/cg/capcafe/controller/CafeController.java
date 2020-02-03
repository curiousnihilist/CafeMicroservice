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

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.service.CafeService;
import com.cg.capcafe.service.MenuService;

/**
 * Rest controller class containing rest end points for accessing cafe resources.
 * @author Akash Verma
 *
 */
@RestController
@RequestMapping(value = "/cafe")
@CrossOrigin(origins = "http://localhost:4200")
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * Post Mapping method for adding new cafe.
	 * @param Cafe
	 * @return Cafe
	 */
	@PostMapping(value = "/add-cafe")
	public Cafe addCafe(@RequestBody Cafe cafe){
		return cafeService.addCafe(cafe);
	}
	
	/**
	 * Put mapping method for updating existing cafe.
	 * @param Cafe
	 * @return Cafe
	 */
	@PutMapping(value = "/update-cafe")
	public Cafe updateCafe(@RequestBody Cafe cafe) {
		return cafeService.updateCafe(cafe);
	}
	
	/**
	 * Delete mapping method for deleting cafe by cafe id.
	 * @param CafeId 
	 * @return Boolean
	 */
	@DeleteMapping(value = "/delete-cafe")
	public boolean deleteCafe(@RequestBody int cafeId) throws CafeNotFoundException{
		return cafeService.deleteCafe(cafeId);
	}
	
	@GetMapping(value = "/get-all-cafe")
	public List<Cafe> getAllCafe() throws CafeNotFoundException{
		return cafeService.getAllCafe();
	}
	
	@GetMapping(value = "/get-by-id")
	public Cafe getCafeById(@RequestParam int cafeId) throws CafeNotFoundException{
		return cafeService.searchById(cafeId);
	}
	
	@GetMapping(value = "/get-by-name")
	public List<Cafe> getCafeByName(@RequestParam String name) throws CafeNotFoundException{
		return cafeService.searchByName(name);
	}
	
	@GetMapping(value = "/get-by-location")
	public List<Cafe> getCafeByLocation(@RequestParam String location) throws CafeNotFoundException{
		return cafeService.searchByLocation(location);
	}
	
	@GetMapping(value = "/get-by-dish")
	public List<Cafe> getCafeByDish(@RequestParam String dish) throws CafeNotFoundException{
		return cafeService.searchByMenu(dish);
	}
	
	@GetMapping(value = "/get-by-rating-range")
	public List<Cafe> getCafeByRatingRange(@RequestParam int min, @RequestParam int max) throws CafeNotFoundException{
		return cafeService.searchByRatings(min, max);
	}
	
	@GetMapping(value = "/get-by-price-range")
	public List<Cafe> getCafeByPriceRange(@RequestParam double min, @RequestParam double max) throws CafeNotFoundException{
		return cafeService.searchByPricing(min, max);
	}
	
	
	
	
	

}