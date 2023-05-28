package com.leleszi.bookstore.repositories;

import com.leleszi.bookstore.models.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest // transactional and rolled back after every test by default
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldBeAbleToFetchAllBooksFromDB() {
        Iterable<Book> all = bookRepository.findAll();
        long totalBookCount = StreamSupport.stream(all.spliterator(), false).count();
        assertEquals(totalBookCount, 2);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldReturnOneBookWhenTestTitleMatches() {
        List<Book> books = bookRepository.findBooksByTitle("Test Title");
        assertEquals(books.size(), 1);
    }
}