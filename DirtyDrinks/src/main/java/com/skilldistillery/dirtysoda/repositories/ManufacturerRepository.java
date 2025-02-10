package com.skilldistillery.dirtysoda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dirtysoda.entities.BaseDrink;
import com.skilldistillery.dirtysoda.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

}
