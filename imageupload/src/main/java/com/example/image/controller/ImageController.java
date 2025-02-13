package com.example.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.image.service.ImageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> addImage(@RequestBody MultipartFile file){
		try {
			imageService.saveImage(file);
			return ResponseEntity.ok("Image Uploaded");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(500).body("failed");
		}
	}
	
	@GetMapping("/getimage/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable int id){
		return new ResponseEntity<byte[]>(imageService.getImage(id), HttpStatus.OK);
	}
}
