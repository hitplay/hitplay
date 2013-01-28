package org.hitplay.audio.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class Genre implements Serializable{
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private static final long serialVersionUID = -2224314533652615146L;
	
	@Id
	@GeneratedValue
	@Column(name = "GENRE_ID")
	private Long id;
	
	@Column(name = "GENRE_NAME")
	private String name;
	
	@Column(name = "GENRE_DESCRIPTION")
	private String description;
}
