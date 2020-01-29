package com.example.UdemySpring.Repositories;

import com.example.UdemySpring.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
