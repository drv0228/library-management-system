package com.application.courselibrary.service;

import com.application.courselibrary.entity.Book;
import com.application.courselibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    ///books : Getting all the books from the database
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    ///book/{id} : Getting a specific book from the database
    public Book findBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }
    ///save-/book : Add a new book to the database
    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }
    ///remove-book/{id} :removing a specific book from the database
    public void deleteBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.deleteById(book.getId());
    }

    public void deleteAll()
    {
        bookRepository.deleteAll();
    }
}
