package com.laporan.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laporan.main.entity.Adminuser;
import com.laporan.main.repository.AdminuserRepository;


@Service
public class ModelAdminuser implements ModelAdminuserInterface {

	@Autowired
	AdminuserRepository adminuserRepo;
	
	@Override
	public List<Adminuser> getAllAdminuser() {
		// TODO Auto-generated method stub
		return (List<Adminuser>) this.adminuserRepo.findAll();
	}

	@Override
	public Adminuser addAdminuser(Adminuser Adminuser) {
		// TODO Auto-generated method stub
		return this.adminuserRepo.save(Adminuser);
	}

	@Override
	public Adminuser getAdminuserById(String id) {
		// TODO Auto-generated method stub
		return this.adminuserRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public void deleteAdminuser(String id) {
		// TODO Auto-generated method stub
		this.adminuserRepo.deleteById(Long.parseLong(id));
	}

}
