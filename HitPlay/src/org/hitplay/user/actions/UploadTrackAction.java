package org.hitplay.user.actions;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hitplay.audio.utils.AudioFileFormatConverter;
import org.hitplay.audio.utils.CODEC;
import org.hitplay.audio.utils.FORMAT;
import org.hitplay.base.actions.UserAction;
import org.hitplay.constants.Handles;
import org.hitplay.constants.Paths;

public class UploadTrackAction extends UserAction implements ServletContextAware{
	
	public String execute(){
		
		AudioFileFormatConverter aff = new AudioFileFormatConverter(file);
		String username = (String)session.get(Handles.USERNAME_HANDLE);
		String root = this.context.getContextPath();
		
		/*  
		 * The File will be stored in the location:
		 *  /HitPlay/Media/{Uploaders Username}/audio
		*/
		String dirToStore = root + Paths.MEDIA + username + Paths.AUDIO;
		
		String fileNameMp3 = dirToStore + filename + ".mp3";
		String fileNameOgg = dirToStore + filename + ".ogg";
		
		File audioOgg = new File(dirToStore, fileNameOgg);
		File audioMp3 = new File(dirToStore, fileNameMp3);
		
		aff.convert(audioMp3, FORMAT.MP3,CODEC.LIBMP3LAME);
		aff.convert(audioOgg, FORMAT.OGG,CODEC.LIBVORBIS);
		
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
	
	public String getContentType() {
		return contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	
	public ServletContext getContext() {
		return context;
	}
	
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Override
	public void setServletContext(ServletContext arg0) {
		context = arg0;
	}
	
	
	
	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}

	private File file;
	private String contentType;
	private String filename;
	private String title;
	private String artist;
	private ServletContext context;

	
}
