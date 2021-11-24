package com.example.demo.domain.userDomain;

import com.example.demo.core.functionalInterfaces.*;

import java.util.UUID;

public interface UserProjection extends FindById<User, UUID>,ExistsByField{
    
    public UUID getId();
    
    public String getName();

    public String getLastName();

    public String getEmail();

    public String getRol();

}