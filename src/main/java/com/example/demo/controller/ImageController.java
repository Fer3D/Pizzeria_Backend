package com.example.demo.controller;

import java.io.IOException;
import javax.validation.Valid;
import com.example.demo.application.imageApplication.CreateOrUpdateImageDTO;
import com.example.demo.application.imageApplication.ImageApplication;
import com.example.demo.application.imageApplication.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public class ImageController {
    public final ImageApplication imageApplication;

    @Autowired
    public ImageController(final ImageApplication imageApplication) {
        this.imageApplication = imageApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ImageDTO> upload(@Valid @RequestParam("image") MultipartFile file) throws IOException {
        CreateOrUpdateImageDTO dto = new CreateOrUpdateImageDTO();
        //dto.setImage(file.getBytes());
        return imageApplication.add(dto);
       
    }
}
