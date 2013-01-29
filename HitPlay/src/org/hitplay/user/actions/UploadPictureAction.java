package org.hitplay.user.actions;

import java.io.File;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hitplay.constants.Handles;
import org.hitplay.constants.Paths;
import org.hitplay.services.ProfileService;
import org.hitplay.services.UploadPictureService;
import org.hitplay.user.dto.Picture;
import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;

import com.opensymphony.xwork2.ActionSupport;

public class UploadPictureAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	public String execute() {

		UserProfile profile = profileService.getProfile((Long) session
				.get(Handles.UID_HANDLE));
		String username = (String) session.get(Handles.USERNAME_HANDLE);

		try {

			String filePath = servletRequest.getServletContext().getRealPath("/")
					+ Paths.MEDIA + username + Paths.PHOTO;
			
			System.out.println("IMAGE FILE PATH"+filePath);
			
			File fileToCreate = new File(filePath, userImageFileName);
			FileUtils.copyFile(userImage, fileToCreate);

			Picture uploadedPicture = new Picture();
			
			uploadedPicture.setPictureDescription(pictureBean
					.getPictureDescription());
		
			uploadedPicture.setPicturePath(servletRequest.getContextPath()+ Paths.MEDIA + username + Paths.PHOTO + userImageFileName);

			uploadPictureService.uploadPicture(profile, uploadedPicture);

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());

			return "input";
		}

		return "success";
	}

	public Picture getPictureBean() {
		return pictureBean;
	}

	public void setPictureBean(Picture pictureBean) {
		this.pictureBean = pictureBean;
	}

	public UploadPictureService getUploadPictureService() {
		return uploadPictureService;
	}

	public void setUploadPictureService(
			UploadPictureService uploadPictureService) {
		this.uploadPictureService = uploadPictureService;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	private Map<String, Object> session;
	private Picture pictureBean;
	private HttpServletRequest servletRequest;
	private File userImage;
	private UploadPictureService uploadPictureService;
	private ProfileService profileService;
	private String userImageContentType;
	private String userImageFileName;

}