package JanOlaf1_BookStore.JanOlaf1_BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.Book;
import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.BookStoreRepository;
import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.Category;

@SpringBootApplication
public class JanOlaf1BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JanOlaf1BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreInitializer(BookStoreRepository kirjasto) {
		return (args) -> {
			kirjasto.save(new Book("Ernest Hemingway", "A Farewell To Arms", 1929, "1232323-21", 0.0));
			kirjasto.save(new Book("George Orwell", "Animal Farm", 1945, "2212343-5", 0.0));
		};
	}

}
