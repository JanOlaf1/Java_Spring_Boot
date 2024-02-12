package JanOlaf1_BookStore.JanOlaf1_BookStore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
