package org.hitplay.admin.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hitplay.validations.Validatable;

@Entity
@Table(name = "ADMINISTRATORS")
public class Administrator implements Serializable, Validatable{

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	private static final long serialVersionUID = 8167442353869001586L;
	
	@Id
	@Column(name = "ADMIN_ID")
	private Long adminId;
	
	@Column(name = "ADMIN_USERNAME")
	private String username;

	@Column(name = "ADMIN_PASSWORD")
	private String password;

	@Column(name = "ADMIN_FIRSTNAME")
	private String firstName;
	
	@Column(name = "ADMIN_LASTNAME")
	private String lastName;
	
}
