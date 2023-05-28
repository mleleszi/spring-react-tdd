package com.leleszi.bookstore.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private UUID id;

    @Column
    @Nonnull
    private String title;

    @Column
    @Nonnull
    private String description;

    @Column
    @Nonnull
    private int releaseYear;
}
