package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];
    // counts the index of the next book
    private int bookCount = 0;
    //requires 1 empty constructor
    public BookStore(){}

    // returns the user array
    public User[] getUsers(){
        return users;
    }

    // sets the user
    public void setUsers(User[] user){
        users = user;
    }

    // returns the book array
    public Book[] getBooks(){
        return books;
    }

    // adds a user to an empty position
    public void addUser(User user){
        // loops through the array
        for (int i = 0; i < users.length; i ++) {
            // finds an empty position and sets it to user
            if (users[i] == null) {
                users[i] = user;
                // ends the loop early
                break;
            }
        }
    }

    // removes a user
    public void removeUser(User user){
        // loops through the array
        for (int i = 0; i < users.length; i ++) {
            // finds if the user matches
            if (users[i] == user) {
                // if it does then sets it to null and breaks the loop
                users[i] = null;
                break;
            }
        }
        // consolidates the user array
        consolidateUsers();
    }

    // consolidates the user array
    public void consolidateUsers(){
        // sets count to 0
        int count = 0;
        // creates a copy of the user array
        User[] copy = new User[users.length];
        // loops through the user array
        for (int i = 0; i < users.length; i ++) {
            // if the user does not equal null then adds it to copy
            if (users[i] != null) {
                copy[count] = users[i];
                // only adds to count for users that have something inside
                count ++;
            }
        }
        // sets users to copy
        users = copy;
    }

    // adds a book to the book array
    public void addBook(Book book){
        // creates a copy of the book array with one more length
        Book[] copy = new Book[bookCount + 1];
        // adds previous books into the copy
        if (books.length > 0) {
            for (int i = 0; i < books.length; i ++) {
                copy[i] = books[i];
            }
        }
        // at the next index to add a book, it adds the book
        copy[bookCount] = book;
        // sets books to copy
        books = copy;
        // adds one to book count
        bookCount ++;
    }

    // inserts a book to the specific index
    public void insertBook(Book book, int index){
        // creates a copy of book with one more in length to account for the new book
        Book[] copy = new Book[bookCount + 1];
        // adds the books before index to copy
        for (int i = 0; i < index; i++) {
            copy[i] = books[i];
        }
        // inserts the new book at the specified index
        copy[index] = book;
    
        // adds the remaining books after the index point
        for (int i = index; i < bookCount; i++) {
            copy[i + 1] = books[i];
        }
        // sets books to copy
        books = copy;
        // adds another to book count
        bookCount ++;
    }

    // removes a book in quantity
    public void removeBook(Book book){
        // creates a copy of book taking into account if the quantity is 0
        Book[] copy = new Book[bookCount - 1];
        // sets 2 count to 0
        int count = 0;
        int count2 = 0;

        // iterates through books
        for (int i = 0; i < books.length; i ++) {
            // finds the book to be removed
            if (books[i] == book) {
                // removes one from the quantity
                books[i].setQuantity(books[i].getQuantity() - 1);
                // sets count2 to the index where the book is found
                count2 = i;
            }
        }
        // finds whether or not the quantity is 0
        if (books[count2].getQuantity() == 0) {
            // if so, iterates through the book array again
            for (int i = 0; i < books.length; i ++) {
                // adds the books with more than 0 quantity to copy
                if (books[i] != book) {
                    copy[count] = books[i];
                    count ++;
                }
            }
            // subtracts from book count as there's one less book
            bookCount --;
            // sets books equal to copy
            books = copy;
        }
    }
    
    // returns the book store info
    public String bookStoreBookInfo(){
        String list = "";
        for (int i = 0; i < books.length;  i ++) {
            list += i + ". " + books[i].bookInfo() + "\n";
        }
        return list;
    } //you are not tested on this method but use it for debugging purposes

}