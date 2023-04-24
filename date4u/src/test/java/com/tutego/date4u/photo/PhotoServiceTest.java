package com.tutego.date4u.photo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Base64;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.TestPropertySource;
import org.stringtemplate.v4.compiler.STParser.andConditional_return;

import com.tutego.date4u.FileSystem;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource(properties = { "spring.shell.interactive.enabled=false" })
public class PhotoServiceTest {

/* 	@Mock(lenient = true)			
	FileSystem fs;

	@Spy
	AwtBicubicThumbnail thumbnail;


	@Mock
	ApplicationEventPublisher publisher;


	@InjectMocks
	PhotoService photoService;
 */


 	@MockBean
	FileSystem fs;

	@Autowired
	PhotoService photoService;
	
	private static final byte[] MINIMAL_JPG = Base64.getDecoder().decode(
				"/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAP//////////////////////////////////////////////////////////////////////////////////////wgALCAABAAEBAREA/8QAFBABAAAAAAAAAAAAAAAAAAAAAP/aAAgBAQABPxA=");
	/**
	 * 
	 */
	@Test
	void successful_photo_upload() {

		String imageName = photoService.upload(MINIMAL_JPG);

		Assertions.assertThat(imageName).isNotEmpty();

		/* 
		verify(fs, times(2)).store(anyString(), any(byte[].class));
		verify(thumbnail).thumbnail(any (byte[].class));
		*/


	}
	
}
