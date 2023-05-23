package com.leleszi.bookstore.controllers;

import com.leleszi.bookstore.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        BookDTO bookDTO = BookDTO
                .builder()
                .title("My First book title")
                .build();

        List<BookDTO> books = new ArrayList<>();
        books.add(bookDTO);

        return ResponseEntity.ok(books);
    }
}
