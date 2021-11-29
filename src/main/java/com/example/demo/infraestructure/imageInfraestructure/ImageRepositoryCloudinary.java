package com.example.demo.infraestructure.imageInfraestructure;

import com.example.demo.domain.imageDomain.Image;
import com.example.demo.domain.imageDomain.ImageCloudinary;

public interface ImageRepositoryCloudinary {
    public ImageCloudinary add(Image image);
}