package com.bootcampProject.pizzeriaBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("ingredients")
public class Ingredients {
    @Id
    @Column("id")
    private UUID id;

    @Column("name")
    private String name;

    @Column("price")
    private BigDecimal price;
}