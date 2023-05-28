package com.leleszi.bookstore.repositories;

import com.leleszi.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<Book, UUID> {
}
