package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploderHlpr {
	
	private String UPLOAD_DIR="D:\\code examples\\spring-boot\\Spring-boot-project\\src\\main\\resources\\static\\uploaded";
	 
	public void uploadFile(MultipartFile file) throws IOException {
		InputStream inputStream = file.getInputStream();
		byte [] data =new byte[inputStream.available()];
		inputStream.read(data);
		
		FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
		fos.write(data);
		fos.flush();
		fos.close();
		
	}

}
