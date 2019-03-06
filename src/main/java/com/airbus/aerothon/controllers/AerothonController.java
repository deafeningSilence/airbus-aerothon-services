package com.airbus.aerothon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.aerothon.entities.impl.Test;
import com.airbus.aerothon.services.TestService;

@RestController
@RequestMapping("/aerothon")
public class AerothonController {

	@Autowired
	TestService testService;
	
	@GetMapping
	public List<Test> getTests() {
		return testService.getTests();
	}
}
