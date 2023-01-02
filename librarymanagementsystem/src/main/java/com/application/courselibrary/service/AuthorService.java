package com.application.courselibrary.service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

///authors : Getting all the authors from the database
    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
///author/{id} : Getting a specific author from the database
    public Author findAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return author;
    }
///save-/author : Add a new author to the database
    public void createAuthor(Author author) {
        authorRepository.save(author);
    }
   // /save-update/{id} : save the update to a specific author
    public void updateAuthor(Author author){
        authorRepository.save(author);
    }
///remove-author/{id} : removing a specific author from the database
    public void deleteAuthor(Long id){
    Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    authorRepository.deleteById(author.getId());
}

}
