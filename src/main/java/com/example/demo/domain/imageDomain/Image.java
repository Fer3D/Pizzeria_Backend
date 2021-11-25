package com.example.demo.domain.imageDomain;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import com.example.demo.core.EntityBase;

import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.Setter;

@RedisHash("Image")

public @Getter @Setter class Image extends EntityBase{
    @NotEmpty
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setId(UUID randomUUID) {
    }
}