package com.example.UdemySpring.Repositories;

import com.example.UdemySpring.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
