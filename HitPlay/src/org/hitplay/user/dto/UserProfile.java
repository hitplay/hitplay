package org.hitplay.user.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import org.hitplay.audio.dto.Audio;

@Entity
@Table(name ="USER_PROFILES")
public class UserProfile implements Serializable {
	
	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public List<Audio> getTrackUploads() {
		return trackUploads;
	}

	public void setTrackUploads(List<Audio> trackUploads) {
		this.trackUploads = trackUploads;
	}

	public void addAudioUpload(Audio audio){
		trackUploads.add(audio);
	}
	
	private static final long serialVersionUID = 2835493132236828090L;	
	
	@Id
	@GeneratedValue
	@Column(name = "PROFILE_ID")
	private long profileId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "AGE")
	private int age;
	
	@Column (name = "GENDER")
	private char gender;
	
	@Column (name = "DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PICTURE_FK")
	private Picture picture;

	@OneToMany
	@JoinColumn(name = "UPLOADER_ID")
	private List<Audio> trackUploads;
	
	//Future implementations Sprint 2
	
	//private Picture primaryPicture
			
	//private music AudioUploads;
			
	//private Map Events

	//Private Photos photos;
	
}
