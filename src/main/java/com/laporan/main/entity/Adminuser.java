package com.laporan.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="admin_user")
public class Adminuser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idAdmin;
	private String nama;
	private String username;
	private String password;
	private String role;
	

}
