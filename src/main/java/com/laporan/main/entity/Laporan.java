package com.laporan.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="laporan")
public class Laporan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLaporan;
	private String namaPelapor;
	private String tanggalKejadian;
	private String lokasiAtm;
	private String keterangan;
	private String gambarBukti;
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idKejadian")
	private Kejadian kejadian;
	
}
