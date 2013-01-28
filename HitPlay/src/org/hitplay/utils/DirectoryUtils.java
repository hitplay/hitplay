package org.hitplay.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryUtils {
	
	
	public void createDirs(){
		for(File file: dirs){
			file.mkdir();
		}
	}
	
	public List<File> getDirs() {
		return dirs;
	}

	public void setDirs(List<File> dirs) {
		this.dirs = dirs;
	}
	
	public void addFile(File file){
		this.dirs.add(file);
	}
	private List<File> dirs = new ArrayList<File>() ;
}
