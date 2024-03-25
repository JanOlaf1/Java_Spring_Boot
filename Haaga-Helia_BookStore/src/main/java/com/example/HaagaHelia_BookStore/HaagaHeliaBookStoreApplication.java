package com.example.HaagaHelia_BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HaagaHelia_BookStore.Domain.Book;
import com.example.HaagaHelia_BookStore.Domain.Category;
import com.example.HaagaHelia_BookStore.Domain.User;
import com.example.HaagaHelia_BookStore.Domain.BookRepository;
import com.example.HaagaHelia_BookStore.Domain.CategoryRepository;
import com.example.HaagaHelia_BookStore.Domain.UserRepository;

@SpringBootApplication
public class HaagaHeliaBookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(HaagaHeliaBookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HaagaHeliaBookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookstoreDemo(BookRepository bRepository, CategoryRepository cRepository,
			UserRepository uRepository) {
		return (args) -> {

			Category category1 = new Category("Horror");
			Category category2 = new Category("Comedy");
			Category category3 = new Category("Drama");
			Category category4 = new Category("Manga");
			Category category5 = new Category("Sci-Fi");
			Category category6 = new Category("Documentary");
			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			cRepository.save(category4);
			cRepository.save(category5);
			cRepository.save(category6);
			bRepository.save(new Book("Ilkka Remes", "Horna", "1234567-8", 2014, 5, category6));

			/*
			 * cRepository.save(new Category("Fantasy"));
			 * cRepository.save(new Category("Comics"));
			 * cRepository.save(new Category("Manga"));
			 * cRepository.save(new Category("Horror"));
			 * cRepository.save(new Category("Sci-Fi"));
			 * cRepository.save(new Category("Realism"));
			 * cRepository.save(new Category("Satire"));
			 * cRepository.save(new Category("Programming"));
			 * 
			 * bRepository.save(new Book("Ernest", "A farewell", "121212-21", 1929, 15, ));
			 * 
			 * bRepository.save(new Book("Ernest Hemingway", "A Farewell to Arms",
			 * 1232323-21, "1929", realismCategory));
			 * 
			 * 
			 */
			uRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@bookstore.fi"));
			uRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"admin@bookstore.fi"));

			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
