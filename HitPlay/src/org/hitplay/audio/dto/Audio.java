package org.hitplay.audio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void addTag(Tag tag){
		tags.add(tag);
		System.out.println("Tag Added To Audio: "+tag.getName());
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

	@OneToOne
	@JoinColumn(name = "GENRE_FK")
	private Genre genre;

	@ManyToMany
	@JoinTable(
		name = "AUDIO_X_TAGS",
		joinColumns = {@JoinColumn(name = "TRACK_ID")},
		inverseJoinColumns={@JoinColumn(name="TAG_ID")}
	)
	private List<Tag> tags = new ArrayList<Tag>();

	// TODO
	// private List<Comment> comments;
}
