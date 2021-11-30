package com.example.demo.domain.userDomain;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.core.EntityBase;
import com.example.demo.core.exceptions.BadRequestException;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table("users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {

    @Column("name")
    @NotBlank
    private String name;

    @Column("lastname")
    @NotBlank
    private String lastName;

    @Column("email")
    @NotBlank
    @Email
    private String email;

    @Column("password")
    private String password;

    @Column("rol")
    @NotNull
    private Rol rol;

    @Column("provider")
    @NotNull
    private Provider provider;

    @Column("state")
    @NotNull
    private State state;

    @Override
    public void validate() {
        super.validate();
        if(this.provider == Provider.LOGIN && !StringUtils.hasText(this.password)) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.addException("password", "A password is required.");
            throw badRequestException;
        } else if(this.provider != Provider.LOGIN && StringUtils.hasText(this.password)) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.addException("password", "Password field must be empty.");
            throw badRequestException;
        }
    }


}
