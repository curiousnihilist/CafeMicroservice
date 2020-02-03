package com.cg.capcafe.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.repo.CafeRepository;

/**
 * Implememtation for CafeService interface. It contains business logics for Cafe service.
 * @author Akash Verma
 *
 */
@Service
@Transactional
public class CafeServiceImpl implements CafeService{

	@Autowired
	private CafeRepository cafeRepo;
	
	@Override
	public Cafe searchById(int cafeId) throws CafeNotFoundException {
		Optional<Cafe> cafe = cafeRepo.findById(cafeId);
		if(!cafe.isPresent())
			throw new CafeNotFoundException("No Cafe Found with ID : "+cafeId);
		return cafe.get();
	}

	@Override
	public Cafe addCafe(Cafe cafe) {
		return cafeRepo.save(cafe);
	}

	@Override
	public Cafe updateCafe(Cafe cafe) {
		return cafeRepo.save(cafe);
	}

	@Override
	public boolean deleteCafe(int cafeId) throws CafeNotFoundException{
		try {
			cafeRepo.deleteById(cafeId);
			return true;
		} catch (Exception e) {
			throw new CafeNotFoundException("No Cafe exist with Id: "+cafeId);
		}
	}

	@Override
	public List<Cafe> searchByPricing(double min, double max) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByPriceRange(min, max);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found with specified price range : "+min+"-"+max);
		return cafes;
	}

	@Override
	public List<Cafe> searchByRatings(int min, int max) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByRatingRange(min, max);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found with specified rating range : "+min+"-"+max);
		return cafes;
	}

	@Override
	public List<Cafe> getAllCafe() throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findAll();
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No Cafe Found!");
		return cafes;
	}

	@Override
	public List<Cafe> searchByName(String name) throws CafeNotFoundException {
		name = "%"+name+"%";
		List<Cafe> cafes = cafeRepo.findByNameContainigIgnoreCase(name);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found by the name : "+name);
		return cafes;
	}

	@Override
	public List<Cafe> searchByLocation(String location) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByLocation(location);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found in location : "+location);
		return cafes;
	}

	@Override
	public List<Cafe> searchByMenu(String foodItem) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByMenu(foodItem);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe available!");
		return cafes;
	}

}
