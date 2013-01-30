package org.hitplay.audio.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hitplay.user.dto.Picture;

@Entity
@Table(name = "TRACKS")
public class Audio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8457074512118262362L;

	public Audio() {
		this.upVotes = new Long(0);
	}

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
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

	public Long getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(Long upVotes) {
		this.upVotes = upVotes;
	}

	public Picture getCoverArt() {
		return coverArt;
	}

	public void setCoverArt(Picture coverArt) {
		this.coverArt = coverArt;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Id
	@GeneratedValue
	@Column(name = "TRACK_ID")
	private Long trackId;

	@Column(name = "OGG_PATH", nullable = false)
	private String oggPath;

	@Column(name = "MP3_PATH", nullable = false)
	private String mp3Path;

	@Column(name = "ARTIST")
	private String artist;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DATE_UPLOADED")
	private Date dateUploaded;

	@Column(name = "TRACK_UPVOTES")
	private Long upVotes;

	@OneToOne
	@JoinColumn(name = "AUDIO_ART_FK")
	private Picture coverArt;

	// TODO
	@OneToOne
	@JoinColumn(name = "GENRE_FK")
	private Genre genre;

	// TODO
	// private Set<Tags> tags;

	// TODO
	// private List<Comment> comments;
}
