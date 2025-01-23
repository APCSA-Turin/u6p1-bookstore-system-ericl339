package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // returns the title
    public String getTitle() {
        return title;
    }

    // sets the title
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // returns the author
    public String getAuthor() {
        return author;
    }

    // sets the author
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    // gets the year published
    public int getYearPublished() {
        return yearPublished;
    }

    // sets the year published
    public void setYearPublished(int newYear) {
        yearPublished = newYear;
    }

    // gets the ISBN
    public String getIsbn() {
        return isbn;
    }

    // sets the ISBN
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    // gets the quantity
    public int getQuantity() {
        return quantity;
    }

    // sets the quantity
    public void setQuantity(int newQuatity) {
        quantity = newQuatity;
    }

    // returns the book info
    public String bookInfo(){
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    } //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
}