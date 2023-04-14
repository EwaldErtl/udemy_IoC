package com.tutego.date4u.photo;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tutego.date4u.FileSystem;

@Service
public class PhotoService { 

	private final FileSystem fs;
	private Thumbnail thumbnail;
	

	public PhotoService(FileSystem fs, @Qualifier("fast") Thumbnail thumbnail) {
		this.fs = fs;
		this.thumbnail = thumbnail;
	}


	public Optional<byte[]> download(String imageName) { 
		try {
			return Optional.ofNullable(fs.load(imageName + ".jpg"));
		} catch (Exception e) {
			return Optional.empty();
		}
	}


	public String upload( byte[] imageBytes ) {
		String imageName = UUID.randomUUID().toString();

		fs.store(imageName + ".jpg", imageBytes);

		byte[] thumbnailBytest = thumbnail.thumbnail(imageBytes);
		fs.store(imageName + "-thumb.jpg", thumbnailBytest);
    return imageName;
  }
}