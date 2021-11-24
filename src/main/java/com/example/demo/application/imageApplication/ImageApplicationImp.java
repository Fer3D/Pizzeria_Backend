package com.example.demo.application.imageApplication;

//import java.io.IOException;
//import java.util.UUID;

import com.example.demo.domain.imageDomain.ImageRepository;
//import com.example.demo.domain.imageDomain.Image;
//import com.example.demo.core.ApplicationBase;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageApplicationImp implements ImageApplication{
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ImageApplicationImp(final ImageRepository imageRepository,
                                final ModelMapper modelMapper) {

        //super((id) -> imageRepository.get(id));
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    public ImageDTO save(CreateOrUpdateImageDTO dto) {

            throw new RuntimeException();
    }

    /*public BytesDTO get(UUID id) {

        throw new RuntimeException();
    }*/
}
