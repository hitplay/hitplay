package org.hitplay.user.actions;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hitplay.constants.Paths;
import org.hitplay.services.RegisterUserService;
import org.hitplay.user.dto.UserProfile;
import org.hitplay.user.dto.User;
import org.hitplay.utils.DirectoryUtils;

public class RegisterAction extends ActionSupport implements ServletRequestAware {
	
	public String execute() {
		
		String rootPath = request.getServletContext().getRealPath("/");	
		DirectoryUtils fileMaker = new DirectoryUtils();
		User usr = registerService.registerUser(userBean, profileBean);
		
		
		if (usr != null) {
			
			//Perform Batch Creation of User Directories
			fileMaker.addFile(new File(rootPath + Paths.MEDIA + userBean.getUsername() ));
			fileMaker.addFile( new File(rootPath + Paths.MEDIA + userBean.getUsername() + Paths.AUDIO));
			fileMaker.addFile( new File(rootPath + Paths.MEDIA+userBean.getUsername() + Paths.PHOTO));
			fileMaker.createDirs();
			
			return "registration-success";
		}
	
		return "success";
	}

	public void validate(){
		/*
		 *  if this form returns a null pointer exception
		 *  the user bypassed the form. just redirect him to the page
		 */
		if(userBean != null){
				
				boolean userNameExist = registerService.exists(userBean.getUsername());
				boolean emailExist = registerService.emailExist(userBean.getEmail());
			
				if(!temp_pass.equals(userBean.getPassword())){
					addFieldError("userBean.password", "Password Does Not Match!");
				}
				
				if(userNameExist){
					addFieldError("usernameError", "Username Already Exists!");
				}
				
				if(emailExist){
					addFieldError("emailError", "Email Already Exists!");
				}
				
				try{
					DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					sdf.setLenient(false);
					Date start_date = sdf.parse(birthDay);
					sdf.format(start_date);
					profileBean.setDateOfBirth(start_date);
				}catch(ParseException pe){
					addFieldError("birthDay", "Invalid Range Of Date");
				}
		 }
	}
	
	public String getTemp_pass() {
		return temp_pass;
	}

	public void setTemp_pass(String temp_pass) {
		this.temp_pass = temp_pass;
	}

	public UserProfile getProfileBean() {
		return profileBean;
	}

	public void setProfileBean(UserProfile profileBean) {
		this.profileBean = profileBean;
	}

	public RegisterUserService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterUserService registerService) {
		this.registerService = registerService;
	}

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	
	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	private static final long serialVersionUID = -3749142113975565348L;
	
	private User userBean;
	private UserProfile profileBean;
	private String temp_pass;
	private String birthDay;
	private RegisterUserService registerService;
	private HttpServletRequest request;
	
}
