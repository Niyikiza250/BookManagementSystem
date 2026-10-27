/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.auca.model;

/**
 *
 * @author N.Eric
 */
public class BookInfo {
    
    private String isbn;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private String category;
    private int publicationYear;

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public BookInfo(String isbn, String title, String author, double price, int quantity, String category, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.publicationYear = publicationYear;
    }

    public BookInfo(String isbn) {
        this.isbn = isbn;
    }

    public BookInfo() {
    }
    
    
    
    
    
}
