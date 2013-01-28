package org.hitplay.user.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hitplay.validations.Validatable;

@Entity
@Table(name = "USERS")
public class User implements Serializable, Validatable{
	
	public User(){
		this.email = "";
		this.username ="";
		this.password = "";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public short getVerfied() {
		return verfied;
	}

	public void setVerfied(short verfied) {
		this.verfied = verfied;
	}
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	private static final long serialVersionUID = 1L;

	@Column(name ="USERNAME", nullable = false)
	private String username;
	

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private long userId;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column (name = "USER_EMAIL",nullable = false)
	private String email;
	
	@Column(name = "VERIFIED",nullable = false)
	private short verfied;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_PROFILE_FK")
	private UserProfile userProfile;
}
