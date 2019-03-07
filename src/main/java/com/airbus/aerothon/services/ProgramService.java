package com.airbus.aerothon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.aerothon.entities.impl.Program;
import com.airbus.aerothon.repository.impl.ProgramRepository;
import com.google.common.collect.Lists;

@Service
public class ProgramService {
	
	@Autowired
	ProgramRepository programRepository;

	public List<Program> getPrograms() {
		return Lists.newArrayList(programRepository.findAll());
	}
	
	
}
