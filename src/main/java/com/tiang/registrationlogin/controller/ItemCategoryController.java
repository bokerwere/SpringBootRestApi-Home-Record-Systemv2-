package com.tiang.registrationlogin.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tiang.registrationlogin.model.ItemCategory;
import com.tiang.registrationlogin.model.Items;
import com.tiang.registrationlogin.service.ItemCategoryService;
import com.tiang.registrationlogin.service.ItemCategoryServiceImp;


@Controller
public class ItemCategoryController {
	@Autowired
	ItemCategoryService itemCategoryService;
	
	@RequestMapping("/category")
	public String showCategoryForm(Model model ,ItemCategory  itemCategory) {
		ItemCategory itemcategory=new ItemCategory();
		model.addAttribute("itemcategory", itemcategory);
		System.out.println(itemcategory);
		List<String>category=Arrays.asList("kitchen","sittingroom","bedroom");
		model.addAttribute("categorylist",category);
		
		return "itemCategory";
		
	}
	
	@GetMapping("/categorylist")
	public String showCategoryList(Model model) {
		List<ItemCategory> category=itemCategoryService.getItemCategoryList();
		model.addAttribute("categorylist",category);
		System.out.println("itemmmmmmmm"+category);
		return "categorytype";
		
	}
	
	
	@GetMapping("/addCategory")
	public String newCategoryForm(	Model model) {
		//ItemCategory category=new ItemCategory();
		//model.addAttribute("categorylist",category);
		//System.out.println("itemmmmmmmm"+category);
		return "redirect:/category";
		
		
		
	}
	
	
	
	
	@PostMapping("/savaCategory")
	public String savaItemCategory( @ModelAttribute("category")ItemCategory  itemCategory ,Model model) {		
		ItemCategory itemCategorise=itemCategoryService.addItemCategory(itemCategory);
		model.addAttribute("categorylist", itemCategorise);
		return"redirect:/categorylist"; 

	}
	
	@GetMapping("/delete/{catId}")
	public String deleteCategory(@PathVariable(value="catId") long 	catId)  {
		itemCategoryService.deleteItem(catId);
		System.out.println("catid deleleted"+catId);
		
		return "redirect:/categorylist";
	}
	
	
	
	@GetMapping("/getItemcategoryByuserId/{id}")
	public String getItemcategoryByuserId(
			@PathVariable(value="id") long id  ,Model model
			) 
	{
		 System.out.println("idnooo ===="+id);
		 List<ItemCategory>   itemCategory= itemCategoryService.getItemCategory();
		 System.out.println("itemCategory ===="+itemCategory);
		 return"redirect:/itemCategory";
		
	}
	
	
	
	@GetMapping("/Categorylist/{id}")
	public String upDateById(@PathVariable(value="id")long id , Model model) {
		ItemCategory itemCategorise=itemCategoryService.findCategoryId(id);
		model.addAttribute("categorylist",itemCategorise );
		
		return"updatecategory";
		
	}
	
	


}