package org.hitplay.audio.utils;

public enum FORMAT {
	WAV("wav"),MP3("mp3"),OGG("ogg");
	
	private  String val;
	
	FORMAT(String val){
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
