package org.hitplay.admin.actions;

import org.hitplay.audio.dto.Tag;
import org.hitplay.services.AudioTaggingService;

import com.opensymphony.xwork2.ActionSupport;

public class AddTagAction extends ActionSupport{
	
	public String execute(){
		audioTaggingService.addTagDefinition(tagBean);
		return "success";
	}
	
	public AudioTaggingService getAudioTaggingService() {
		return audioTaggingService;
	}

	public void setAudioTaggingService(AudioTaggingService audioTaggingService) {
		this.audioTaggingService = audioTaggingService;
	}

	
	
	public Tag getTagBean() {
		return tagBean;
	}

	public void setTagBean(Tag tagBean) {
		this.tagBean = tagBean;
	}



	private AudioTaggingService audioTaggingService;
	
	private Tag tagBean;
}
