package com.example.demo.core;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;


import lombok.Getter;
import lombok.Setter;

public @Getter @Setter abstract class EntityBase implements Persistable<UUID>{
    
    @Id
    @Column
    private UUID id;

    @Transient
    private boolean isThisNew = false;

    

    public boolean isNew(){
        return this.isThisNew;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals (Object obj) {

        if (!(obj instanceof EntityBase)){
            return false;
        }

        EntityBase tmpEntity = (EntityBase) obj;

        return this.id.equals(tmpEntity.id);
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }
}