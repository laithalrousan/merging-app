package com.almosafer.merge_app.repository;

import com.almosafer.merge_app.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private final List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book save(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}