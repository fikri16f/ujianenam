package com.laporan.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.laporan.main.entity.Laporan;

public interface LaporanRepository extends CrudRepository<Laporan, Long> {
	
	@Query(value = "select * from laporan where status is not null",nativeQuery=true)
	public List<Laporan> findStatusResponse(); 

	@Query(value = "select * from laporan where status is null",nativeQuery=true)
	public List<Laporan> findStatusNull(); 

}
