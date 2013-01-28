package org.hitplay.admin.actions;

import org.hitplay.audio.dto.Genre;
import org.hitplay.audio.dto.Tag;
import org.hitplay.services.AudioTaggingService;

import com.opensymphony.xwork2.ActionSupport;

public class AddGenreAction extends ActionSupport{

	public String execute(){
		audioTaggingService.addGenreDefinition(genreBean);
		return "success";
	}
	
	
	public AudioTaggingService getAudioTaggingService() {
		return audioTaggingService;
	}

	public void setAudioTaggingService(AudioTaggingService audioTaggingService) {
		this.audioTaggingService = audioTaggingService;
	}

	
	public Genre getGenreBean() {
		return genreBean;
	}

	public void setGenreBean(Genre genreBean) {
		this.genreBean = genreBean;
	}


	private AudioTaggingService audioTaggingService;
	private Genre genreBean;
}
