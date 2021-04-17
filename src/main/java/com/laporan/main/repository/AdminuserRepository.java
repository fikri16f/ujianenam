package com.laporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.laporan.main.entity.Adminuser;


public interface AdminuserRepository extends CrudRepository<Adminuser, Long>{

	public Adminuser findByUsername(String username);

}
