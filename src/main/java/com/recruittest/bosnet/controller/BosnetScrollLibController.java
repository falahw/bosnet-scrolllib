package com.recruittest.bosnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.recruittest.bosnet.model.People;
import com.recruittest.bosnet.service.BosnetScrollLibService;

@Controller
public class BosnetScrollLibController {

	@Autowired
	private BosnetScrollLibService bosService;
	
	@GetMapping("/")
	private String viewHomePage(Model model) {
		// TODO Auto-generated method stub
		return findPaginatedPage(1, "id", "asc", model);
	}
	
	@GetMapping("/halaman/{noHalaman}")
	private String findPaginatedPage(@PathVariable(value = "noHalaman") int noHal,
			@RequestParam("colToBeSorted") String sortField,
			@RequestParam("sortAscOrDesc") String sortDir,
			Model model) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		
		Page<People> halaman = bosService.findPaginated(noHal, pageSize, sortField, sortDir);
		List<People> pplList = halaman.getContent();
		
		model.addAttribute("currentPage", noHal);
		model.addAttribute("totalHalaman", halaman.getTotalPages());
		model.addAttribute("totalItems", halaman.getTotalElements());
		
		model.addAttribute("sortCol", sortField);
		model.addAttribute("sortDirection", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listOfPeople", pplList);
		
		return "home";
	}
}
