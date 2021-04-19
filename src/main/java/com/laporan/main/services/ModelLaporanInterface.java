package com.laporan.main.services;

import java.util.List;

import com.laporan.main.entity.Laporan;

public interface ModelLaporanInterface {

public List<Laporan> getAllLaporan();
public Laporan addLaporan(Laporan laporan);
public Laporan getLaporanById(String id);
public Laporan cariLaporan(String id);
public List<Laporan> getLaporanProses();
public List<Laporan> getLaporanResponse();
	
}
