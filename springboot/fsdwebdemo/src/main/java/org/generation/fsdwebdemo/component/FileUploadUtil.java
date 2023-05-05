package org.generation.fsdwebdemo.component;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
	public static void saveFile(String uploadDir1, String fileName,
								MultipartFile multipartFile) throws IOException {

		Path uploadPath1 = Paths.get(uploadDir1);

		try (InputStream inputStream = multipartFile.getInputStream()) {

			// "D:\Eve\Documents\Books\Study\FSD\Lesson-Codes-1\springboot\t-shirt_new.jpg"
			Path filePath1 = uploadPath1.resolve(fileName);
			Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Could not save image file: " + fileName, ioe);
		}
	}
}
