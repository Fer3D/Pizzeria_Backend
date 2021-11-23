package com.example.demo.domain.userDomain;
import com.example.demo.domain.EntityBase;
import com.example.demo.domain.userDomain.Rol;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table("users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {
    
    @Id
    @Column("id")
    protected UUID id;

    @Column("name")
    private String name;

    @Column("lastname")
    private String lastName;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

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
