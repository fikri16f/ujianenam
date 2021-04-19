package com.laporan.main.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.laporan.main.utility.FileUtility;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.laporan.main.entity.Laporan;
import com.laporan.main.services.ModelKejadian;
import com.laporan.main.services.ModelLaporan;

@Controller
public class LaporanPage {

	@Autowired
	ModelLaporan modellaporan;
	
	@Autowired
	ModelKejadian modelKejadian;
	
	@GetMapping("/laporan/view")
	public String viewIndexLaporan(Model model) {
		
		model.addAttribute("listLaporan",modellaporan.getAllLaporan());
		model.addAttribute("active",2);
		
		return "view_laporan";
	}
	
//	@GetMapping("/laporan/dashboard")
//	public String viewDashboard(Model model) {
//		model.addAttribute("active",5);
//				
//		
//		return "view_laporan";
//	}
	
	@GetMapping("/laporan/add")
	public String viewAddLaporan(String id, Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("laporan",new Laporan());
		model.addAttribute("listKejadian", modelKejadian.getAllKejadian());

		return "add_laporan";
	}
	
	@PostMapping("/laporan/view")
	public String addPertanyaan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Laporan laporan, Model model) throws IOException { {
		   String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
	         
	        String uploadDir = "user-photos/" ;
	        
	        FileUtility.saveFile(uploadDir, fileName, file);
	 
       laporan.setGambarBukti("/"+uploadDir + fileName);
        this.modellaporan.addLaporan(laporan);

		model.addAttribute("listlaporan",modellaporan.getAllLaporan());
		
		return "redirect:/laporan/view";
	  }
	}
	
	@GetMapping("/laporan/approve/{id}")
	public String ApproveLaporan(@PathVariable String id, Model model) {
		
		Laporan laporan = modellaporan.cariLaporan(id);
		// buat penampung data MataKuliah di halaman htmlnya
		laporan.setStatus("approve");
		this.modellaporan.addLaporan(laporan);
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/reject/{id}")
	public String RejectLaporan(@PathVariable String id, Model model) {
		
		Laporan laporan = modellaporan.cariLaporan(id);
		// buat penampung data MataKuliah di halaman htmlnya
		laporan.setStatus("reject");
		this.modellaporan.addLaporan(laporan);
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/print")
	public String exportPDF() {
		
		Print();
		
		return "redirect:/laporan/view";	
				
	}
	
	
	public void Print (){
		try {
			File file = ResourceUtils.getFile("classpath:laporan1.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			List<Laporan> lstLaporan = modellaporan.getAllLaporan();
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstLaporan);
	        
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy","Juaracoding");
	        
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        String path = "E://laporan1.pdf";
	        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
	        
	       
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
	}
	
	
}
