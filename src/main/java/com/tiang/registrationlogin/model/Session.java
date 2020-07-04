package com.tiang.registrationlogin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long session_Id;
	long user_Id;
	
	public Session() {
		
	}

	public long getSession_Id() {
		return session_Id;
	}

	public void setSession_Id(long session_Id) {
		this.session_Id = session_Id;
	}

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	public Session(long session_Id, long user_Id) {
		super();
		this.session_Id = session_Id;
		this.user_Id = user_Id;
	}

	@Override
	public String toString() {
		return "Session [session_Id=" + session_Id + ", user_Id=" + user_Id + "]";
	}
	

	
	
}
