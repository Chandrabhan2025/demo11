package com.example.image.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.image.entity.Image;
import com.example.image.repository.ImageRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public Image saveImage(MultipartFile file) throws IOException{
		Image image = new Image();
		image.setData(file.getBytes());
		return imageRepository.save(image);
	}
	
	public byte[] getImage(int id) {
		Image image = imageRepository.findById(id).orElse(null);
		return image.getData();
	}

}
