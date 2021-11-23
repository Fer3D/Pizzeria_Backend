package com.example.demo.core;

import java.util.UUID;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
//import org.junit.internal.runners.rules.validation;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.validation.annotation.Validated;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter abstract class EntityBase implements Persistable<UUID> {
    
    @Id
    @Column //(ColumnDefinition = "binary"(16))
    private UUID id;

    @Transient
    protected boolean isThisNew = false;

    
    @Override
    public boolean isNew() {
        return this.isThisNew;
    }

    public void validate(){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof EntityBase)) {
            return false;
        }
        EntityBase tmpEntity = (EntityBase) obj;
        return this.id.equals(tmpEntity.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
