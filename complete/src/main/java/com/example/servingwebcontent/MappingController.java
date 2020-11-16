package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingController {

	@GetMapping("/Contact")
	public String contact(Model model) {
		return "Contact";
	}
	
	@Autowired
	GroceryList groceryList;
	
	@RequestMapping(value="/Groceries",method=RequestMethod.GET)
	public String GroceryList(Model model) {
		model.addAttribute("Grocery", groceryList.findAll());
		return "Groceries";
	} 
	
	@RequestMapping(value="/Groceries",method=RequestMethod.POST)
	public String groceryAdd(@RequestParam(required=false) boolean isFruit, @RequestParam(required=false) boolean isMeat, 
			@RequestParam(required=false) boolean isDairy, @RequestParam String name, Model model) {
		Grocery newGrocery = new Grocery();
		try {
			newGrocery.setIsFruit(isFruit);
		}
		catch(Exception e) {
			newGrocery.setIsFruit(false);
		}
		try {
			newGrocery.setIsMeat(isMeat);
		}
		catch(Exception e) {
			newGrocery.setIsMeat(false);
		}
		try {
			newGrocery.setIsDairy(isDairy);
		}
		catch(Exception e) {
			newGrocery.setIsDairy(false);
		}
		newGrocery.setName(name);
		groceryList.save(newGrocery);
		model.addAttribute("Grocery", groceryList.findAll());
		return "redirect:/Groceries";
	}
	
	

}
