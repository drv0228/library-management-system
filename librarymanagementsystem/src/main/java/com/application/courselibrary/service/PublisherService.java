package com.application.courselibrary.service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    ///publishers : Getting all the publishers from the database
    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }
    ///publishers/{id} : Getting a specific publisher from the database
    public Publisher findPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        return publisher;
    }
    ///save-/publisher : Add a new publisher to the database
    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }
    // /save-update/{id} : save the update to a specific publisher
    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
    ///remove-publisher/{id} : removing a specific publisher from the database
    public void deletePublisher(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found"));
        publisherRepository.deleteById(publisher.getId());
    }
}
