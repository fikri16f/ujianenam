package com.laporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.laporan.main.entity.Kejadian;


public interface KejadianRepository extends CrudRepository<Kejadian, Long>{

	public Kejadian findByIdKejadian (Long id);
	
	
}
