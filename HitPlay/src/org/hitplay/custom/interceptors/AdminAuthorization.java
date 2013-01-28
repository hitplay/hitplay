package org.hitplay.custom.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminAuthorization extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		String role = (String) session.get("role");
		
	
		if(role != null && role.equals("ADMIN")){
			return "logged-in";
		}
		return invocation.invoke();
	}

}
