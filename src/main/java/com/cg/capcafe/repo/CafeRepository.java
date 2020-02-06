package com.cg.capcafe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.exception.CafeNotFoundException;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {
	
	@Query("SELECT c FROM Cafe c WHERE c.name LIKE ?1")
	List<Cafe> findByNameContainigIgnoreCase(String name);
	
	List<Cafe> findByLocation(String location);
	
	@Query("SELECT c FROM Cafe c WHERE c.avgRating BETWEEN ?1 AND ?2")
	List<Cafe> findByRatingRange(double min, double max) throws CafeNotFoundException;
	
	@Query("SELECT c FROM Cafe c WHERE c.avgPrice BETWEEN ?1 AND ?2")
	List<Cafe> findByPriceRange(int min, int max) throws CafeNotFoundException;
	
	@Query("SELECT c FROM Cafe c JOIN FETCH c.menu m WHERE m.name = ?1")
	List<Cafe> findByMenu(String foodItem);
	
	@Query("SELECT c FROM Cafe c WHERE c.location = ?1 AND c.name LIKE ?2")
	List<Cafe> searchFood(String location, String name );
}
