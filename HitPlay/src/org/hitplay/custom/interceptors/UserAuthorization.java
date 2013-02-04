package org.hitplay.custom.interceptors;

import java.util.Map;

import org.hitplay.constants.Handles;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserAuthorization extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		String role = (String) session.get(Handles.USER_HANDLE);
		
		
		if(role != null && role.equals(Handles.USER_HANDLE)){
			System.out.println("HELLO");
			return "logged-in";
			
		}
		
		
		return invocation.invoke();
	}

}
