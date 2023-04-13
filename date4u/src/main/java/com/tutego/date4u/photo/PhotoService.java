package com.tutego.date4u.photo;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tutego.date4u.FileSystem;

@Service
public class PhotoService { 

	private final FileSystem fs;
	

	public PhotoService(FileSystem fs) {
		this.fs = fs;
	}


	public Optional<byte[]> download(String imageName) { 
		try {
			return Optional.ofNullable(fs.load(imageName + ".jpg"));
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}