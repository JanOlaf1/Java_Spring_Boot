package com.example.HaagaHelia_BookStore.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String titteli);

    // void saveAll(Category category);
}
