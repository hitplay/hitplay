package org.hitplay.audio.utils;


import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;

public class AudioFileFormatConverter {

	protected AudioAttributes audioAttr = new AudioAttributes();
	protected EncodingAttributes encoAttrs = new EncodingAttributes();
	protected Encoder encoder = new Encoder();

	protected static final Integer BITRATE = new Integer(128000);// Minimal
																	// bitrate
																	// only
	protected static final Integer CHANNELS = new Integer(2); // 2 for stereo, 1
																// for mono
	protected static final Integer SAMPLINGRATE = new Integer(44100);// For good
																		// quality.
	private File src;

	/*
	 * @param - The Source File that would be used for conversion
	 */
	public AudioFileFormatConverter(File src) {
		this.src = src;
		this.initAttr();
	}

	
	
	public void initAttr() {
		audioAttr.setBitRate(BITRATE);
		audioAttr.setChannels(CHANNELS);
		audioAttr.setSamplingRate(SAMPLINGRATE);
	}

	/*
	 * @param File trgt - target result of the converted ile
	 * 
	 * @param FORMAT format - audio format to be used
	 * 
	 * @param CODEC codec - codec for the audio
	 * 
	 * @return - Returns the converted file
	 */
	public File convert(File trgt, FORMAT format, CODEC codec) {
		audioAttr.setCodec(codec.getVal());
		encoAttrs.setFormat(format.getVal());
		encoAttrs.setAudioAttributes(audioAttr);
		try {
			encoder.encode(src, trgt, encoAttrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
		return trgt;
	}
}
