package org.hitplay.user.actions;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hitplay.services.ProfileService;
import org.hitplay.user.dto.UserProfile;
import com.opensymphony.xwork2.ActionSupport;

public class ViewProfileAction extends ActionSupport{
	
	public String execute(){
		
		UserProfile profile = profileService.getProfile(id);

		setProfile(profile);
		if(getProfile() == null){
			return "profile-not-found";
		}
		return "success";
	}
	
	public Long getId() {
		return id;
	}
	
	/*
	 * Stop ognl will not complain if
	 * the user manipulated the id url with a String;
	 */
	public void setId(String id){
		try{
			Long temp = Long.parseLong(id);
			this.setId(temp);
		}catch(NumberFormatException nce){
			setId(new Long(0));//Default value
		}
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public UserProfile getProfile() {
		return profile;
	}
	
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	private Long id;
	private UserProfile profile;
	private ProfileService profileService;
	
}
