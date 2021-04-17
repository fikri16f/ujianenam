package com.laporan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laporan.main.entity.Kejadian;
import com.laporan.main.services.ModelKejadian;

@Controller
public class KejadianPage {
	
	@Autowired
	ModelKejadian modelKejadian;
	
	
	@GetMapping("/kejadian/view")
	public String viewIndexKejadian(Model model) {
		
		model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
		model.addAttribute("active",3);
		return "view_kejadian";
	}
	
	
	@GetMapping("/kejadian/add")
	public String viewAddKejadian(Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("kejadian",new Kejadian());
		
		return "add_Kejadian";
	}
	
	@PostMapping("/kejadian/view")
	  public String addKejadian(@ModelAttribute Kejadian Kejadian, Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		this.modelKejadian.addKejadian(Kejadian);
		model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
		
		
		return "redirect:/kejadian/view";
	}
	
	
	@GetMapping("/kejadian/update/{id}")
	public String viewUpdateKejadian(@PathVariable String id, Model model) {
		
		Kejadian Kejadian = modelKejadian.getKejadianById(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("kejadian",Kejadian);
		
		return "add_kejadian";
	}
	
	@GetMapping("/kejadian/delete/{id}")
	public String deleteMataKuliah(@PathVariable String id, Model model) {
		
		this.modelKejadian.deleteKejadian(id);
		model.addAttribute("listKejadian",modelKejadian.getAllKejadian());
		
		
		return "redirect:/kejadian/view";
	}

	
}
