package org.hitplay.user.actions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.hitplay.audio.utils.AudioFileFormatConverter;
import org.hitplay.audio.utils.CODEC;
import org.hitplay.audio.utils.FORMAT;
import org.hitplay.base.actions.UserAction;
import org.hitplay.constants.Handles;
import org.hitplay.constants.Paths;

public class UploadTrackAction extends UserAction implements ServletRequestAware{
	
	public String execute(){
		
		AudioFileFormatConverter aff = new AudioFileFormatConverter(file);
		String username = (String)session.get(Handles.USERNAME_HANDLE);
		String root = request.getServletContext().getRealPath("/");
		
		/*  
		 * The File will be stored in the location:
		 *  /HitPlay/Media/{Uploaders Username}/audio
		*/
		String dirToStore = root + Paths.MEDIA + username + Paths.AUDIO;
		
		//We will name the uploaded audio file on the date and time it was uploaded
		//For Uniqueness of the user upload
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		String audioFileName = dateFormat.format(cal.getTime());
		
		String fileNameMp3 = dirToStore + audioFileName + ".mp3";
		String fileNameOgg = dirToStore + audioFileName + ".ogg";
		
		File audioOgg = new File(fileNameOgg);
		File audioMp3 = new File(fileNameMp3);
		
		System.out.println(aff.convert(audioMp3, FORMAT.MP3,CODEC.LIBMP3LAME));
		System.out.println(aff.convert(audioOgg, FORMAT.OGG,CODEC.LIBVORBIS));
		
		//TODO
		//Some Service Layers
		
		
		return "success";
	}
	
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
		
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	
	private File file;
	private String filename;
	private String title;
	private String artist;
	private HttpServletRequest request;


	
}
