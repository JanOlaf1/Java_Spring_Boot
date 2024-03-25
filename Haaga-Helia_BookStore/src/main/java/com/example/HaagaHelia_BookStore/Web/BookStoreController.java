package com.example.HaagaHelia_BookStore.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.HaagaHelia_BookStore.Domain.*;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookStoreController {

    @Autowired
    private BookRepository bRepository;
    @Autowired
    private CategoryRepository cRepository;

    // login
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // booklist
    @RequestMapping(value = "/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bRepository.findAll());
        return "booklist";
    }

    // kategoria lisäys
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/saveCategory")
    public String saveCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("category", cRepository.findAll());

        return "addcategory";
    }

    // kirjan lisäys
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    // editointi
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bRepository.findById(bookId).orElse(null));
        model.addAttribute("category", cRepository.findAll());
        return "editbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        bRepository.save(book);
        return "redirect:booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

}