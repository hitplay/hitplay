package org.hitplay.user.actions;

import java.util.List;

import org.hitplay.misc.PaginationHelper;
import org.hitplay.services.ProfileService;
import org.hitplay.user.dto.UserProfile;

import com.opensymphony.xwork2.ActionSupport;

public class SearchProfileAction extends ActionSupport{
	

	public String execute(){

		//Create an instance of the PaginationHelper
		//Can be also be injected to prevent from creating new instances every access to this Action Class.
		paginationHelperBean = new PaginationHelper();
		
		//If page and name variable are not populated,
		//meaning we just got from the page for the first time,
		//we set the current page to 0
		//But if we got through the page using the pagination navigation,
		//we get the page variable and set our bean to that value.
		if(page == 0 && name != null){
			paginationHelperBean.setCurrent_page(0);
		} else {
			paginationHelperBean.setCurrent_page(page);
		}
		
		//Set the paginationBean for display references in JSP later
		paginationHelperBean.setPer_page(RESULTS_PER_PAGE);
		paginationHelperBean.setTotal_count(profileService.countSearchProfiles(name, paginationHelperBean.getCurrent_page(), RESULTS_PER_PAGE));
		paginationHelperBean.setNumber_of_pages();
		
		profiles = profileService.searchProfiles(name, paginationHelperBean.getCurrent_page(), RESULTS_PER_PAGE);
		
		return "success";
	}
	
	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public List<UserProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<UserProfile> profiles) {
		this.profiles = profiles;
	}

	public PaginationHelper getPaginationHelperBean() {
		return paginationHelperBean;
	}

	public void setPaginationHelperBean(PaginationHelper paginationHelperBean) {
		this.paginationHelperBean = paginationHelperBean;
	}
	
	public static final int  RESULTS_PER_PAGE = 5;
	
	private PaginationHelper paginationHelperBean;
	private String name;
	private ProfileService profileService;
	private int page;
	private List<UserProfile> profiles;


}