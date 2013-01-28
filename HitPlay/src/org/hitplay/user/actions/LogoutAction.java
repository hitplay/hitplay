package org.hitplay.user.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	public String execute(){
		session.clear();
		return "success";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session  = session;
	}
	
	private Map<String, Object> session;
	
}
