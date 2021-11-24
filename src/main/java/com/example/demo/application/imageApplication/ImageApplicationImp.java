package com.example.demo.application.imageApplication;

import com.example.demo.domain.imageDomain.ImageRepository;
import com.example.demo.domain.imageDomain.Image;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

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

    @Override
    public Mono<ImageDTO> add(CreateOrUpdateImageDTO dto) {
        Image image = modelMapper.map(dto, Image.class);
    image.setId(UUID.randomUUID());
    return this.imageRepository.add(image)
                               .flatMap(monoImage -> Mono.just(this.modelMapper.map(monoImage, ImageDTO.class)));
    }

    /*public BytesDTO get(UUID id) {
        throw new RuntimeException();
    }*/
}
