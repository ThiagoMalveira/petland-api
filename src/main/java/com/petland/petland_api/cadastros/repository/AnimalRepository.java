package com.petland.petland_api.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petland.petland_api.cadastros.model.entities.AnimalEntity;


public interface AnimalRepository  extends JpaRepository<AnimalEntity, Integer>{
} 