package org.hitplay.user.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.services.AuthenticateLoginService;
import org.hitplay.user.dto.User;
import org.hitplay.constants.*;
public class LoginAction extends ActionSupport implements SessionAware{

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
		}	
	
	}
	
	public AuthenticateLoginService getAuthenticateLoginService() {
		return authenticateLoginService;
	}

	public void setAuthenticateLoginService(
			AuthenticateLoginService authenticateLoginService) {
		this.authenticateLoginService = authenticateLoginService;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	private Map<String,Object> session; 
	

}
