package org.generation.fsdwebdemo.component;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// Azure Blob Storage quickstart
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;

public class FileUploadUtil {
	public static void saveFile(String uploadDir1, String fileName,
								MultipartFile multipartFile) throws IOException {

		// Test upload for local folder
//		Path uploadPath1 = Paths.get(uploadDir1);
//
//		try (InputStream inputStream = multipartFile.getInputStream()) {
//
//			// "D:\Lesson-Codes-1\springboot\t-shirt_new.jpg"
//			Path filePath1 = uploadPath1.resolve(fileName);
//			Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException ioe) {
//			throw new IOException("Could not save image file: " + fileName, ioe);
//		}

		// Actual upload of images to Azure storage
		/* This is the setup using Azure storage */
		String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=productimagedemotp;AccountKey=8rVndJyQp9GYHFGMyAyvT2NlNoICsH4FTGlgHIDBt1TrjtEUNdq7jT80o65NIxSQSaY1C6clQfgb+AStZNbTOg==;EndpointSuffix=core.windows.net";

		// Create a connection between this web application with the storage container
		// that we created in our Azure server
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();

		// Specify which container we want to get the images from
		String containerName = "prodimage";

		// To get the container with the images
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

		// fileName refers to which filename that we want to upload (e.g. t-shirt_new.jpg)
		BlobClient blobClient = containerClient.getBlobClient(fileName);

		InputStream inputStream = multipartFile.getInputStream();
		blobClient.upload(inputStream);

	}
}
