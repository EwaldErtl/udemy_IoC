package com.tutego.date4u.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("date4u")
public class Date4UProperties {

	private FileSystem fileSystem = new FileSystem();

	public static class FileSystem{ 

		/**
		 *  Required minimum free disk space for local filesystem
		 */
		private long minimumFreeDiskSpace = 1_000_000;

		public long getMinimumFreeDiskSpace() {
			return minimumFreeDiskSpace;
		}

		public void setMinimumFreeDiskSpace(long minimumFreeDiskSpace) {
			this.minimumFreeDiskSpace = minimumFreeDiskSpace;
		}
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

}