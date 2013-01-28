package org.hitplay.admin.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hitplay.admin.dto.Administrator;
import org.hitplay.services.AuthenticateLoginService;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport implements SessionAware {

	public String execute() {
		return "success";
	}

	public void validate() {
		if (!hasFieldErrors()) {
			Administrator adminValid = authenticateLoginService
					.isValid(adminBean);

			if (adminValid == null) {
				addActionError("Incorrect username or password");
			} else {
				session.put("admin_id",adminValid.getAdminId());
				session.put("admin_username", adminValid.getUsername());
				session.put("role", "ADMIN");
			}
		}

	}

	public Administrator getAdminBean() {
		return adminBean;
	}

	public void setAdminBean(Administrator adminBean) {
		this.adminBean = adminBean;
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

	private Administrator adminBean;
	private AuthenticateLoginService authenticateLoginService;
	private Map<String, Object> session;

}
