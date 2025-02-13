package com.example.image.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imageid;
	
	@Lob
	private byte[] data;
	
}
