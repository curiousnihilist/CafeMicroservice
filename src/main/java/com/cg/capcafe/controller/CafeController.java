package com.cg.capcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.service.CafeService;

/**
 * rest controller class containig rest end points for accessing cafe resources.
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
	private 

}
