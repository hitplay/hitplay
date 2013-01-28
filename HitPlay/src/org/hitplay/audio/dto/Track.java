package org.hitplay.audio.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRACKS")
public class Track implements Serializable {

	
	public Track(){
		this.mp3Path = "";
		this.oggPath = "";
		this.artist = "";
		this.title = "";
	}
	
	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getOggPath() {
		return oggPath;
	}

	public void setOggPath(String oggPath) {
		this.oggPath = oggPath;
	}

	public String getMp3Path() {
		return mp3Path;
	}

	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	
	private static final long serialVersionUID = -7549500455381571965L;
	
	@Id
	@GeneratedValue
	@Column(name = "TRACK_ID")
	private int trackId;
	
	@Column(name = "OGG_PATH", nullable = false)
	private String oggPath;
	
	@Column(name = "MP3_PATH", nullable = false)
	private String mp3Path;
	
	@Column(name = "PLAY_COUNT")
	private int playCount;	
	
	@Column(name = "ARTIST", nullable = false, length=20)
	private String artist;
	
	@Column(name = "TITLE", nullable = false, length=20)
	private String title;
	
	@Column(name = "DATE_UPLOADED", nullable = false)
	private Date dateUploaded;
	
	//TODO
	//private Genre genre;
	
	//TODO
	//private Set<Tags> tags;
	
	//TODO
	//private List<Comment> comments;
}
