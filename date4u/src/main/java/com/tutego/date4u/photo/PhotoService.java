package com.tutego.date4u.photo;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.tutego.date4u.FileSystem;
import com.tutego.date4u.event.NewPhotoEvent;

@Service
public class PhotoService { 

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final FileSystem fs;
	private Thumbnail thumbnail;
	private ApplicationEventPublisher applicationEventPublisher;

	

	public PhotoService(FileSystem fs, @Qualifier("fast") Thumbnail thumbnail, ApplicationEventPublisher applicationEventPublisher) {
		this.fs = fs;
		this.thumbnail = thumbnail;
		this.applicationEventPublisher = applicationEventPublisher;
	}


	@Cacheable("date4u.filesystem.files")
	public Optional<byte[]> download(String imageName) { 
		logger.info("Retrieve file data for {}", imageName );
		try {
			return Optional.ofNullable(fs.load(imageName + ".jpg"));
		} catch (Exception e) {
			return Optional.empty();
		}
	}


	public String upload( byte[] imageBytes ) {
		String imageName = UUID.randomUUID().toString();

		applicationEventPublisher.publishEvent(new  NewPhotoEvent(imageName, OffsetDateTime.now()));


		fs.store(imageName + ".jpg", imageBytes);

		byte[] thumbnailBytest = thumbnail.thumbnail(imageBytes);
		fs.store(imageName + "-thumb.jpg", thumbnailBytest);

    return imageName;
  }
}