package com.tiang.registrationlogin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiang.registrationlogin.model.ItemCategory;
import com.tiang.registrationlogin.model.Items;
import com.tiang.registrationlogin.model.User;
import com.tiang.registrationlogin.service.ItemCategoryService;
import com.tiang.registrationlogin.service.ItemService;
@Controller
public class ItemsController {
	@Autowired
	ItemCategoryService itemCategoryService;
	
	@Autowired
	ItemService itemService;
	//display all item 
	@RequestMapping("/item")
	public String getAllItems(Model model) {
		model.addAttribute("itemlist", itemService.getAllItem());
		
		return  "home";
		
	}
	
	@GetMapping("/newItemForm")
	public String newItemForm(Model model ,Items item) {
		//create model attribute to bind form data
		//ItemCategory category=new ItemCategory();
		System.out.println(item);
		
		//Items item=new Items();
		model.addAttribute("item",item);
		 List<ItemCategory>  itemCategory= itemCategoryService.getItemCategory();
			System.out.println("itemCategory========="+itemCategory);
		model.addAttribute("categorylist", itemCategory);
		return"new_item";
	}
	
	@PostMapping("/saveitem")
	public String saveItems(@ModelAttribute("item")Items item ) {
		//saving items to database
		  User user=new User();
				  //user.getId();
		itemService.SaveItem(item);
		System.out.println("userid========="+user.getId());
		return"redirect:/item";
		
		}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showItemUpdateForm(@PathVariable(value="id") long id ,Model model) {
		
	      Items  item= itemService.findItemId(id);
	      System.out.println("idnooo ===="+id);
		model.addAttribute("item" ,item);
		return"update_item";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

	    // call delete employee method 
	    this.itemService.deleteById(id);
	    return "redirect:/item";
	}
	

}
 