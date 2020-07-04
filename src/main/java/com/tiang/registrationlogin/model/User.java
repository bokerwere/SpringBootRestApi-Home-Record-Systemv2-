package com.tiang.registrationlogin.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Size(min=2 ,max=255 ,message="firstname must be between 2-255 characters.")
	@Column(name="first_name")
	private String firstName;
	
	@Size(min=2 ,max=255 ,message="lastname must be between 2-255 characters.")
	@Column(name="last_name")
	private String lastName;
	
	 @Email
	 @NotBlank(message="email required")
	@Column(name="email")
	private String email;
	
	 private Date createdAt;
	 private Date upDatedAt;
	 @PrePersist
	 public void OnCreated(){ createdAt=new  Date();
		}
	 @PreUpdate
	 public void OnUpdate() {upDatedAt=new Date();}
	 @Size(min=2 ,max=64, message=" password  must be between 2-64 characters")
	 @Column(name="password")
	 private String password;
	  
	 
	 @Size(min=2 ,max=64, message=" password  must be between 2-64 characters")
	 @Transient
	 private String confirm;
	 
	 @OneToMany(targetEntity =Items.class , cascade = CascadeType.ALL)
	 @JoinColumn(name="user_id" , referencedColumnName = "id")
	 
	   List<Items>item; 
	
	public User() {
		
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", createdAt=" + createdAt + ", upDatedAt=" + upDatedAt + ", password=" + password + ", confirm="
				+ confirm + ", item=" + item + "]";
	}
	public User(long id,
			@Size(min = 2, max = 255, message = "firstname must be between 2-255 characters.") String firstName,
			@Size(min = 2, max = 255, message = "lastname must be between 2-255 characters.") String lastName,
			@Email @NotBlank(message = "email required") String email, Date createdAt, Date upDatedAt,
			@Size(min = 2, max = 64, message = " password  must be between 2-64 characters") String password,
			@Size(min = 2, max = 64, message = " password  must be between 2-64 characters") String confirm,
			List<Items> item) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.createdAt = createdAt;
		this.upDatedAt = upDatedAt;
		this.password = password;
		this.confirm = confirm;
		this.item = item;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpDatedAt() {
		return upDatedAt;
	}
	public void setUpDatedAt(Date upDatedAt) {
		this.upDatedAt = upDatedAt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public List<Items> getItem() {
		return item;
	}
	public void setItem(List<Items> item) {
		this.item = item;
	}
	

}
