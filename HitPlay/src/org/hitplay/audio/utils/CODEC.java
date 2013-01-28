package org.hitplay.audio.utils;

public enum CODEC {
	LIBVORBIS("vorbis"),LIBMP3LAME("libmp3lame");
	
	private String val;
	
	CODEC(String val){
		this.val = val;
	}
	public String getVal() {
		return val;
	}
	
}