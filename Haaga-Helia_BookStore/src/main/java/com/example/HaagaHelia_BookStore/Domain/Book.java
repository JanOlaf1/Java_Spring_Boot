package com.example.HaagaHelia_BookStore.Domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author;
    private String title;
    private int publication_year;
    private String isbn;
    private double price;
    @ManyToOne
    @JoinColumn(name = "categoryId")

    private Category category;

    public Book() {
        super();
        this.author = null;
        this.title = null;
        this.isbn = null;

    }

    public Book(String author, String title, String isbn, int publication_year, double price, Category category) {
        super();
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publication_year = publication_year;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year="
                    + ", publication_year=" + publication_year + ", price=" + price + " category =" + this.getCategory()
                    + "]";
        else
            return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn
                    + ", publication_year=" + publication_year
                    + ", price=" + price + "]";

    }
}
