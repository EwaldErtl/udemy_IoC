package com.tutego.date4u.shell;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.util.unit.DataSize;

import com.tutego.date4u.FileSystem;
import com.tutego.date4u.configuration.Date4UProperties;

@ShellComponent
public class FsCommand {
	
	private FileSystem fs;
	private String userHome;

	@Value("${date4u.filesystem.minimumFreeDiskSpace: 100}")
	private long minimumFreeDiskSpace;

	private Date4UProperties date4UProperties;

	
	public FsCommand(FileSystem fs, @Value("${user.home: my default}") String userHome, Date4UProperties date4UProperties) {
		this.fs = fs;
		this.userHome = userHome;
		this.date4UProperties = date4UProperties;
	}

	@ShellMethod("Display if path exists")
	public boolean exists(Path path) {
		return fs.exists(path);
		
	}

	@ShellMethod( "Display free disk space")
	public long minimumFreeDiskSpace() {
		return date4UProperties.getFileSystem().getMinimumFreeDiskSpace();
		//return minimumFreeDiskSpace;
	}

	@ShellMethod("tolowerCaseh")
	public String toLowerCase(String input) { 
		return input.toLowerCase();
	}

	@ShellMethod("Display free Disk space")
	public String freeDiskSpace() { 
		return DataSize.ofBytes(fs.getFreeDiskSapce()).toGigabytes() + " GB";
	}


	@ShellMethod("Display Userhome")
	public String  userHome() { 
		return userHome;
	}
}



@Component
class StringToPathConverter implements Converter<String, Path> {

	@Override
	@Nullable
	public Path convert(String source) {
		// TODO Auto-generated method stub
		return Path.of(source);
	}

}