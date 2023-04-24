package com.tutego.date4u;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class FileSystem {

	private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");
	public FileSystem() {

		if (!Files.isDirectory(root)) {
			try {
				Files.createDirectory(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public long getFreeDiskSapce() { 
		return root.toFile().getFreeSpace();
	}

	public byte[] load(String fileName) { 
		try {
			return Files.readAllBytes(resolve(fileName));
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	private Path resolve(String fileName) {
		Path path = root.resolve(fileName).toAbsolutePath().normalize();
		if (!path.startsWith(root)) {
			throw new SecurityException("Access to " + path + " denied");
		}
		return path;
	}

	public void store(String filename, byte[] bytes) { 
		try {
			Files.write(resolve(filename), bytes);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}

	}

	public boolean exists(Path path) {
		System.out.println(path);
		return true;
	}
    
}
