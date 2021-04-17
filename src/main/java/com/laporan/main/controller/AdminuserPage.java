package com.laporan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laporan.main.entity.Adminuser;
import com.laporan.main.services.ModelAdminuser;

@Controller
public class AdminuserPage {
	
	@Autowired
	ModelAdminuser modelAdminuser;
	
	
	@GetMapping("/adminuser/view")
	public String viewIndexAdminuser(Model model) {
		
		model.addAttribute("listAdminuser",modelAdminuser.getAllAdminuser());
		model.addAttribute("active",1);
		
		return "view_adminuser";
	}
	
	
	@GetMapping("/adminuser/add")
	public String viewAddAdminuser(Model model) {
		
		// buat penampung data Adminuser di halaman htmlnya
		model.addAttribute("adminuser",new Adminuser());
		
		return "add_adminuser";
	}
	
	@PostMapping("/adminuser/view")
	  public String addAdminuser(@ModelAttribute Adminuser adminuser, Model model) {
		
		// buat penampung data Adminuser di halaman htmlnya
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = adminuser.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        adminuser.setPassword(encodedPassword);		
		
		this.modelAdminuser.addAdminuser(adminuser);
		model.addAttribute("listAdminuser",modelAdminuser.getAllAdminuser());
		
		
		return "redirect:/adminuser/view";
	}
	
	
	@GetMapping("/adminuser/update/{id}")
	public String viewUpdateAdminuser(@PathVariable String id, Model model) {
		
		Adminuser Adminuser = modelAdminuser.getAdminuserById(id);
		// buat penampung data Adminuser di halaman htmlnya
		model.addAttribute("adminuser", Adminuser);  
		
		return "add_adminuser";
	}
	
	@GetMapping("/adminuser/delete/{id}")
	public String deleteAdminuser(@PathVariable String id, Model model) {
		
		this.modelAdminuser.deleteAdminuser(id);
		model.addAttribute("listAdminuser",modelAdminuser.getAllAdminuser());
		
		
		return "redirect:/adminuser/view";
	}
}
