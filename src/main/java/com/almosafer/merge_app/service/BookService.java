package com.almosafer.merge_app.service;

import com.almosafer.merge_app.model.Book;
import com.almosafer.merge_app.repository.BookRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        if(bookDetails.getTitle().equalsIgnoreCase(book.getTitle())) {
            if(StringUtils.isNotBlank(bookDetails.getAuthor())) {
                book.setAuthor(bookDetails.getAuthor());
            }
            if (bookDetails.getYear()<=2022){
                book.setYear(2022);
            } else {
                book.setYear(bookDetails.getYear());
            }
        }
        return book;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}