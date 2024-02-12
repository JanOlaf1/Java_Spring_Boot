package JanOlaf1_BookStore.JanOlaf1_BookStore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.Book;

@Controller
public class BookstoreController {
    @RequestMapping(value = { "/booklist" }, method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Ernest Hemingway", "A Farewell To Arms", 1929, "1232323-21", 0.0));
        books.add(new Book("George Orwell", "Animal Farm", 1945, "2212343-5", 0.0));

        model.addAttribute("books", books);

        return "booklist";
    }
}
