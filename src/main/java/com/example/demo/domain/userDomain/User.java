package com.example.demo.domain.userDomain;
import com.example.demo.domain.userDomain.Rol;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.core.EntityBase;
import com.example.demo.domain.userDomain.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table("users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {
    
    @NotBlank
    @Id
    @Column("id")
    protected UUID id;

    @NotBlank
    @Column("name")
    private String name;

    @NotBlank
    @Column("lastname")
    private String lastName;

    @NotBlank
    @Column("email")
    private String email;

    @NotBlank
    @Column("password")
    private String password;

    @NotNull
    @Column("rol")
    private Rol rol = Rol.USER;

    @Override
    public String toString() {
        return String.format("User {id: %s, name: %s, lastName: %s, email: %s, rol: %s}", this.getId(), this.getName(),
                this.getLastName(), this.getEmail(), this.getRol());
    }

    @Override
    public boolean isNew() {
        return this.isThisNew;
    }
}
