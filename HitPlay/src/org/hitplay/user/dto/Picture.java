package org.hitplay.user.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name ="PICTURE")
public class Picture implements Serializable {
	
private static final long serialVersionUID = 2835493132236828090L;	

	public long getPictureID() {
		return pictureID;
	}

	public void setPictureID(long pictureID) {
		this.pictureID = pictureID;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getPictureDescription() {
		return pictureDescription;
	}

	public void setPictureDescription(String pictureDescription) {
		this.pictureDescription = pictureDescription;
	}


	@Id
	@GeneratedValue
	@Column(name = "PIC_ID", nullable = false)
	private long pictureID;
			
	@Column(name = "PIC_PATH")
	private String picturePath;
	
	@Column(name = "PIC_DESC")
	private String pictureDescription;

}