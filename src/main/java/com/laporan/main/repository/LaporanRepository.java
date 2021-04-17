package com.laporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.laporan.main.entity.Laporan;

public interface LaporanRepository extends CrudRepository<Laporan, Long> {
	
//	public Laporan findByNama(String nama);
//	public Laporan findByIdLaporan(Long id);

}
