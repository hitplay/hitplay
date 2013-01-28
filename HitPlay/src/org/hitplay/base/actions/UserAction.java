package org.hitplay.base.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.services.ProfileService;
import org.hitplay.user.dto.UserProfile;

import com.opensymphony.xwork2.ActionSupport;

public  class UserAction extends ActionSupport implements SessionAware{

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	public UserProfile getProfileBean() {
		return profileBean;
	}

	public void setProfileBean(UserProfile profileBean) {
		this.profileBean = profileBean;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	protected ProfileService profileService;
	protected UserProfile profileBean;
	protected Map<String,Object> session; 
	
}
