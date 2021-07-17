package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.*;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploderHlpr fileUploderHlpr;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()) {
			try {
				fileUploderHlpr.uploadFile(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			return ResponseEntity.internalServerError().body("No file is uploaded");
		}
		return ResponseEntity.ok("Working");
		
	}

}
