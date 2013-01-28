package org.hitplay.audio.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAGS")
public class Tag implements Serializable{
	
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

	private static final long serialVersionUID = -7450676224552186827L;
	
	@Id
	@GeneratedValue
	@Column(name = "TAG_ID")
	private Long id;
	
	@Column(name = "TAG_NAME")
	private String name;
	
	@Column(name = "TAG_DESCRIPTION")
	private String description;
	
	
}
