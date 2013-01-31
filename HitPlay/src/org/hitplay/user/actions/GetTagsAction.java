package org.hitplay.user.actions;

import java.util.ArrayList;
import java.util.List;

import org.hitplay.audio.dto.SimpleTagDTO;
import org.hitplay.audio.dto.Tag;
import org.hitplay.services.AudioTaggingService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetTagsAction extends ActionSupport{
	
	
	public String execute(){
		Gson gson = new Gson();
		
		String k = "[";	
		 List<Tag> tgs = audioTaggingService.findTagsByName(q);
		 ArrayList<String> sts = new ArrayList<String>();
		 
		 for(Tag tg : tgs){
			 sts.add(tg.getName());
		 }

		 tag = gson.toJson(sts);
		 return Action.SUCCESS;
	}
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setAudioTaggingService(AudioTaggingService audioTaggingService) {
		this.audioTaggingService = audioTaggingService;
	}


	private String q;
	private AudioTaggingService audioTaggingService;
	public String  tag;
}
