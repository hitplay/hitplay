package org.hitplay.user.actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.util.ServletContextAware;
import org.hitplay.audio.dto.Audio;
import org.hitplay.audio.dto.Genre;
import org.hitplay.audio.utils.AudioFileFormatConverter;
import org.hitplay.audio.utils.CODEC;
import org.hitplay.audio.utils.FORMAT;
import org.hitplay.base.actions.UserAction;
import org.hitplay.constants.Handles;
import org.hitplay.constants.Paths;
import org.hitplay.services.AudioServices;
import org.hitplay.services.AudioTaggingService;
import org.hitplay.services.ProfileService;
import org.hitplay.services.UploadPictureService;
import org.hitplay.user.dto.UserProfile;

public class UploadTrackAction extends UserAction implements
		ServletRequestAware {

	public String execute() {
		
		String username = (String) session.get(Handles.USERNAME_HANDLE);
		Long userId = (Long)session.get(Handles.UID_HANDLE);
		UserProfile profile = this.profileService.getProfile(userId);
		String root = request.getServletContext().getRealPath("/");

		/*
		 * The File will be stored in the location: /HitPlay/Media/{Uploaders
		 * Username}/audio
		 */
		String dirToStore = root + Paths.MEDIA + username + Paths.AUDIO;

		/* We will name the uploaded audio file on the date and time it was
		* uploaded
		* For Uniqueness of the user upload
		*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		String audioFileName = dateFormat.format(cal.getTime());

		// Place to Store the files in the Server
		String fileNameMp3 = dirToStore + audioFileName + ".mp3";
		String fileNameOgg = dirToStore + audioFileName + ".ogg";

		// Creates the audiofiles
		File audioOgg = new File(fileNameOgg);
		File audioMp3 = new File(fileNameMp3);

		// Converts The File To an Audio Mp3 and OGG extension
		AudioFileFormatConverter aff = new AudioFileFormatConverter(file);
		aff.convert(audioMp3, FORMAT.MP3, CODEC.LIBMP3LAME);
		aff.convert(audioOgg, FORMAT.OGG, CODEC.LIBVORBIS);

		// Store the The Relative Paths in the DB.
		String relMp3Path = request.getServletContext().getContextPath()
				+ Paths.MEDIA + username + Paths.AUDIO + audioFileName + ".mp3";
		String relOggPath = request.getServletContext().getContextPath()
				+ Paths.MEDIA + username + Paths.AUDIO + audioFileName + ".ogg";
		
		
		// Some Service Layers
		audioBean.setMp3Path(relMp3Path);
		audioBean.setOggPath(relOggPath);
		audioBean.setDateUploaded(new Date());
		audioBean.setGenre(audioTaggingService.getGenre(genreId));
		audioService.uploadAudio(profile, audioBean);
		
		
		
		return "success";
	}

	public String populateBeans(){
		this.setGenres(audioTaggingService.getAllGenres());
		return "success";
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setUploadPictureService(
			UploadPictureService uploadPictureService) {
		this.uploadPictureService = uploadPictureService;
	}
	
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setAudioBean(Audio audioBean) {
		this.audioBean = audioBean;
	}
	
	public void setAudioService(AudioServices audioService) {
		this.audioService = audioService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
	public Audio getAudioBean() {
		return audioBean;
	}
	
	public AudioTaggingService getAudioTaggingService() {
		return audioTaggingService;
	}

	public void setAudioTaggingService(AudioTaggingService audioTaggingService) {
		this.audioTaggingService = audioTaggingService;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	private File file;
	private Audio audioBean;
	private Long genreId;
	private UploadPictureService uploadPictureService;
	private AudioServices audioService;
	private ProfileService profileService;
	private List<Genre> genres;
	private AudioTaggingService audioTaggingService;
	private HttpServletRequest request;

}