package com.laporan.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laporan.main.entity.Kejadian;
import com.laporan.main.repository.KejadianRepository;

@Service
public class ModelKejadian implements ModelKejadianInterface {

	@Autowired
	KejadianRepository kejadianRepo;

	@Override
	public List<Kejadian> getAllKejadian() {
		// TODO Auto-generated method stub
		return (List<Kejadian>) this.kejadianRepo.findAll();
	}

	@Override
	public Kejadian addKejadian(Kejadian Kejadian) {
		// TODO Auto-generated method stub
		return this.kejadianRepo.save(Kejadian);
	}

	@Override
	public Kejadian getKejadianById(String id) {
		// TODO Auto-generated method stub
		return ((Kejadian)this.kejadianRepo.findByIdKejadian(Long.parseLong(id)));
	}

	@Override
	public void deleteKejadian(String id) {
		// TODO Auto-generated method stub
		this.kejadianRepo.deleteById(Long.parseLong(id));
	}
	
	
	

}
