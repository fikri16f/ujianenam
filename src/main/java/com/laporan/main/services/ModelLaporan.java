package com.laporan.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laporan.main.entity.Laporan;
import com.laporan.main.repository.LaporanRepository;

@Service
public class ModelLaporan implements ModelLaporanInterface{

	@Autowired
	LaporanRepository laporanRepo;
	
	
	@Override
	public List<Laporan> getAllLaporan() {
		// TODO Auto-generated method stub
		return (List<Laporan>) this.laporanRepo.findAll();
	}

	@Override
	public Laporan addLaporan(Laporan laporan) {
		// TODO Auto-generated method stub
		return this.laporanRepo.save(laporan);
	}

	@Override
	public Laporan getLaporanById(String id) {
		// TODO Auto-generated method stub
		return this.laporanRepo.findById(Long.parseLong(id)).get();
	}
	
	@Override
	public Laporan cariLaporan(String id) {
		// TODO Auto-generated method stub
		return this.laporanRepo.findById(Long.parseLong(id)).get();
	}

	@Override
	public List<Laporan> getLaporanProses() {
		// TODO Auto-generated method stub
		return this.laporanRepo.findStatusNull();
	}

	@Override
	public List<Laporan> getLaporanResponse() {
		// TODO Auto-generated method stub
		return this.laporanRepo.findStatusResponse();
	}

}
