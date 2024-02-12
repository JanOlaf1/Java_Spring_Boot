
package JanOlaf1_BookStore.JanOlaf1_BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.Book;
import JanOlaf1_BookStore.JanOlaf1_BookStore.domain.BookStoreRepository;

@Controller
public class BookstoreController {
    /*
     * Injektoidaan riippuvuus ilman asetuksia.
     * Injecting dependency without configurations.
     */
    @Autowired
    private BookStoreRepository kirjasto;

    /*
     * haetaan kaikki kirjat. booklist.html
     * Searching for the books from booklist.html
     */
    @RequestMapping(value = { "/booklist" }, method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", kirjasto.findAll());
        return "booklist";
    }

    /*
     * Lisätään kirja
     * adding books
     */
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    /*
     * tallennetaan kirja
     * Saving book
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        kirjasto.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id, Model model) {
        kirjasto.deleteById(id);
        return "redirect:/booklist";
    }

    // Edit specified book/muokkaa
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", kirjasto.findById(bookId));

        return "editbook";
    }

}
