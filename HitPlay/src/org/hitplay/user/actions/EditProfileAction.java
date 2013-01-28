package org.hitplay.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.constants.Handles;
import org.hitplay.services.ProfileService;
import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;

import com.opensymphony.xwork2.ActionSupport;

public class EditProfileAction extends ActionSupport implements SessionAware{
	
	public String execute(){
		Long user_id = (Long) session.get(Handles.UID_HANDLE);
		UserProfile profile = profileService.getProfile(user_id);
		profile.setFirstName(profileBean.getFirstName());
		profile.setLastName(profileBean.getLastName());
		profile.setGender(profileBean.getGender());
		profileService.updateProfile(profile);
		return "success";
		}
	
	public String populateProfile(){
		this.profileBean = profileService.getProfile((Long)session.get("user_id"));
		return "success";
	}
	
	public UserProfile getProfileBean() {
		return profileBean;
	}

	public void setProfileBean(UserProfile profileBean) {
		this.profileBean = profileBean;
	}
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private UserProfile profileBean;
	private ProfileService profileService;
	private Map<String, Object> session;
	
}
