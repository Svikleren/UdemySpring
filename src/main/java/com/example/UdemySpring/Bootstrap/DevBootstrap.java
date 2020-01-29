package com.example.UdemySpring.Bootstrap;

import com.example.UdemySpring.Model.Author;
import com.example.UdemySpring.Model.Book;
import com.example.UdemySpring.Model.Publisher;
import com.example.UdemySpring.Repositories.AuthorRepository;
import com.example.UdemySpring.Repositories.BookRepository;
import com.example.UdemySpring.Repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    private void initData(){

        Publisher pub = new Publisher("pub1", "pub2");
        publisherRepository.save(pub);

        Author eric = new Author("Eric", "Aut");
        Book book = new Book("Asdasdas", "12345", pub);


        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(pub);

        Author second = new Author("Second", "Author");
        Book book2 = new Book("2ndBook", "98765", pub);

        second.getBooks().add(book2);

        authorRepository.save(eric);
        bookRepository.save(book);
        authorRepository.save(second);
        bookRepository.save(book2);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
