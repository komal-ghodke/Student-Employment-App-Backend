package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Company;
import com.psl.training.model.Selection;
import com.psl.training.model.Student;
import com.psl.training.services.SelectionService;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins="http//localhost:3000")
public class SelectionController {

	@Autowired
	SelectionService service;
	
	@GetMapping("/selections")
	public List<Selection> getSelections(){
		return service.getAllSelections();
		
	}
	@GetMapping("/selections1")
	public Selection getSelectionById(@PathVariable int id){
		return service.getSelectionsById(id);
		
	}
	@GetMapping("/selectionsapp")
	public List<Selection> getSelectionByapp(){
		return service.getSelectionByIsapp();
		
	}
	@GetMapping("/selectionssel")
	public List<Selection> getSelectionByselect(){
		return service.getSelectionByIsselect();
		
	}
	@PostMapping("/selections")
	public String insertSelection(@RequestBody Selection sel){		
		 service.insertSelection(sel);
		return "Selection table created sucessfully";
	}
	@PutMapping("/selections")
	
	public String updateSelection(@RequestBody Selection sel )
	{		
	
		int flag=0;
	    flag=service.updateSelections(sel);
	    if(flag==1)
	    return "student selected successfully";
	    else
	    	return "student can not be  select";
		
		
	}
}
