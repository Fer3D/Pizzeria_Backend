package com.example.demo.core;

import java.util.UUID;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter abstract class EntityBase implements Persistable<UUID> {
    
    @Id
    protected UUID id;

    @Transient
    protected boolean isThisNew = false;

    @Override
    public boolean isNew() {
        return this.isThisNew;
    }

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

    @Override
    public UUID getId() {
        return id;
    }
}