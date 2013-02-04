package org.hitplay.user.actions;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.services.AuthenticateLoginService;

import org.hitplay.user.dto.User;
import org.hitplay.base.actions.UserAction;
import org.hitplay.constants.*;
public class LoginAction extends UserAction implements SessionAware{
	
	/* 
	 * To Be Easily Noticeable.
	 * Inherits The FF:
	 * Map<String, Obj> session
	 * ProfileService profileService;
	 * UserProfile profileBean;
	 */
	
	public String execute() {
		return "success";
	}

	public void validate() {
		User userValid = authenticateLoginService.isValid(userBean);
		if (userValid == null) {
			addActionError("Incorrect username or password");
		}else{
			session.put(Handles.USERNAME_HANDLE,userValid.getUsername());
			session.put(Handles.UID_HANDLE,userValid.getUserId());	
			session.put(Handles.USER_HANDLE,Handles.USER_HANDLE);	
		}	
	
	}
	
	public AuthenticateLoginService getAuthenticateLoginService() {
		return authenticateLoginService;
	}

	public void setAuthenticateLoginService(
			AuthenticateLoginService authenticateLoginService) {
		this.authenticateLoginService = authenticateLoginService;
	}
	
	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	private static final long serialVersionUID = -7538017902866360347L;

	private User userBean;
	private AuthenticateLoginService authenticateLoginService;

}
