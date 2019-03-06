package com.airbus.aerothon.dao;

import org.springframework.data.repository.CrudRepository;

import com.airbus.aerothon.entities.impl.Test;


public interface TestRepository extends CrudRepository<Test, Integer> {

}
