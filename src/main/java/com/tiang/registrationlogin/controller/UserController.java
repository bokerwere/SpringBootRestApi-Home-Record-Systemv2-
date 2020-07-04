package com.tiang.registrationlogin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tiang.registrationlogin.model.User;
import com.tiang.registrationlogin.service.UserService;

@Controller
//@RequestMapping("/session")
@SessionAttributes({"user"})
public class UserController{
	String pw;

	@Autowired
	UserService userService;
	@Autowired
	ItemsController itemsController;
	
	@ModelAttribute("user") 
	public User user() {
		User user=new User();
		System.out.println("kkkkkkkkkkkkkkkkkkkkkk"+user.getId());
		return user;

		}
	
	
	String rs;	
	@RequestMapping("/")
	public String register(@ModelAttribute("user"  ) User user ) { 
		//ModelAndView modelAndViewer=new ModelAndView();
		//modelAndViewer.setViewName("signup");
		System.out.println("user loaded");
		System.out.println("user loaded");
		return "signup";
		
	}
	
	@PostMapping("/register")
 public String register(
		 @Valid  @ModelAttribute User user 
		 , BindingResult rs  ,
		 RedirectAttributes redirectAttributes,
		 Model model)
	{
		System.out.println("user===");
		if(rs.hasErrors()) {
			return "signup";
	
		} else {
		//encrypt  password
		
			
		User userExist=userService.findByEmail(user.getEmail());
		
		//ModelAndView modelAndViewer=new ModelAndView();
		//modelAndViewer.setViewName("signup");
		
		if(userExist!=null) {
			
			//redirectAttributes.addFlashAttribute("user", "user email address");
			model.addAttribute("email", "email already used");
			return "signup";
		}else {
			
			
			
		 
		if(!user.getPassword().equals(user.getConfirm())) {
		 model.addAttribute("error", "email already used");
		 System.out.println("password dont match");
		 return "signup"; 
		 }else
			 
		 // pw= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	     // user.setPassword(pw);
				
			userService.creat(user);
			//redirectAttributes.addFlashAttribute("user", user);
		
		    user();
		
			return "login";
			
		
		}}
		
		}	
	
	
	
	@GetMapping("/login")
	public String showLoginForm( Model model ) {
		return "login";
	}
	@PostMapping("/home")
	public String login(
			@RequestParam String email ,
					@RequestParam String password ,
			Model model ,HttpSession httpSession ,HttpServletRequest request) {
		  // String userEmail=request.getParameter("email");
		 ///  model.addAttribute("input" ,userEmail);
		
		
	if(email.length()<1) {
			
			// model.addAttribute("email" ,email);
			System.out.println("invalid credential");
			model.addAttribute("user" ,new User());
			return " redirect:/login";
		}
		User u= userService.findByEmail(email);
		 if(u==null) {
			 System.out.println("wrong credential!!!");
			 model.addAttribute("user" ,new User());
			 return "login";
		 }else {
			 
			// Boolean matches=BCrypt.checkpw(password,u.getPassword());
			 String matches=u.getPassword();
			 if(matches.matches(password)) {
				 System.out.println("userID===="+u.getId());
				 httpSession.setAttribute("user", u.getId());
				itemsController.getAllItems(model);
			 return "home";
				 
			 }else {
			 System.out.println("invalid");
			 model.addAttribute("user" ,new User());
			 return "signup";
		 }
		
	}
		
		 }
	
@GetMapping("/home")
public String dashboad(Model model ,HttpSession session) {
	Long id=(Long)session.getAttribute("user");
	User user =new User();
	if(id==null) {
		return"signup";
		 
		}else {
			session.setAttribute("user", user);
			System.out.println("kkkkkkkkkkkkkkkkkkk"+user.getId());
		User u=userService.findById(id);
		model.addAttribute("user" ,u);
		return "home";
		
	}
		
	
}






}

			
	    // userService.findByEmailAndPassword(email, password);
		
		
		
	

