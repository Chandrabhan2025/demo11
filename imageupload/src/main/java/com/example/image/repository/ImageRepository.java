package com.example.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.image.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
