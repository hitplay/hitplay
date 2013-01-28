package org.hitplay.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.base.actions.UserAction;
import org.hitplay.constants.Handles;
import org.hitplay.services.ProfileService;
import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;

import com.opensymphony.xwork2.ActionSupport;

public class EditProfileAction extends UserAction implements SessionAware {

	public String execute() {
		Long user_id = (Long) session.get(Handles.UID_HANDLE);
		UserProfile profile = profileService.getProfile(user_id);
		profile.setFirstName(profileBean.getFirstName());
		profile.setLastName(profileBean.getLastName());
		profile.setGender(profileBean.getGender());
		profileService.updateProfile(profile);
		return "success";
	}

	public String populateProfile() {
		Long currentUserId = (Long) session.get(Handles.UID_HANDLE);
		profileBean = profileService.getProfile(currentUserId);
		return "success";
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private static final long serialVersionUID = -5262701921412953168L;
	private Map<String, Object> session;
}
