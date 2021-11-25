package com.example.demo.application.imageApplication;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class CreateOrUpdateImageDTO {
    @NotEmpty
    public byte[] image;

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
}