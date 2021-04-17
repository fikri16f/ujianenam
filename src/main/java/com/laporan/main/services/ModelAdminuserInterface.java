package com.laporan.main.services;

import java.util.List;

import com.laporan.main.entity.Adminuser;



public interface ModelAdminuserInterface {
	
	public List<Adminuser> getAllAdminuser();
	
	public Adminuser addAdminuser(Adminuser Adminuser);
	public Adminuser getAdminuserById(String id);
	public void deleteAdminuser(String id);

}
