package com.example.demo.domain.imageDomain;

import javax.validation.constraints.NotEmpty;
import com.example.demo.core.EntityBase;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class Image extends EntityBase {
    @NotEmpty
    private byte[] image;
}