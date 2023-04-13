package com.tutego.date4u.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.FileSystem;

@ShellComponent
public class FsCommand {
	
	private FileSystem fs;

	
	public FsCommand(FileSystem fs) {
		this.fs = fs;
	}


	@ShellMethod( "Display free disk space")
	public long minimumFreeDiskSpace() {
		return 1_000_000;
	}

	@ShellMethod("tolowerCaseh")
	public String toLowerCase(String input) { 
		return input.toLowerCase();
	}

	@ShellMethod("Display free Disk space")
	public String freeDiskSpace() { 
		return DataSize.ofBytes(fs.getFreeDiskSapce()).toGigabytes() + " GB";
	}
}
