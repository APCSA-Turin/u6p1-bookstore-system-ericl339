package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name;
    private String Id;
    Book[] book = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }

    // returns a name
    public String getName() {
        return name;
    }

    // sets the name
    public void setName(String newName) {
        name = newName;
    }

    // returns the id
    public String getId() {
        return Id;
    }

    // sets the id
    public void setId(String newId) {
        Id = newId;
    }

    // returns the book array
    public Book[] getBooks() {
        return book;
    }

    // sets the book array
    public void setBooks(Book[] newBook) {
        book = newBook;
    }

    // returns a book list
    public String bookListInfo(){
        // creates an empty string
        String list = "";
        // for loop for each item in the array
        for (Book thing : book) {
            // if the book is null, empty takes its place
            if (thing == null) {
                list += "empty\n";
            }
            // else, bookInfo() is called and it prints out its info
            else {
                list += thing.bookInfo() + "\n";
            }
        }
        return list;
    } //returns a booklist for the user, if empty, output "empty"

    // returns the info of the user
    public String userInfo(){
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo();
    } //returns  "Name: []\nID: []\nBooks:\n[]"
       
}