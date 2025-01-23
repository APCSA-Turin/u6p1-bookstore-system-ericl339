package com.example.project;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        // creates a book store
        BookStore store = new BookStore(); 
        System.out.println("---------------------------------------------------------");
        System.out.println("*************************Library*************************");
        System.out.println("---------------------------------------------------------");
        // creates a scanner object
        Scanner scanner = new Scanner(System.in);
        // asks the user for their choice
        System.out.println("1. Add new book\n2. Remove book\n3. Insert book\n4. Add user\n5. Remove user\n6. Print user info\n7. Set book to user\n8. Print library books\n9. End");
        int choice = scanner.nextInt();
        scanner.nextLine();
        // runs only if the user's choice is not 9
        while (choice != 9) {
            if (choice == 1) {
                // adds a new book
                System.out.println("-----------------------------Adding new book-----------------------------");
                // asks the user for the book info
                System.out.println("Enter title of the book:");
                String title = scanner.nextLine();
                System.out.println("Enter name of the author:");
                String author = scanner.nextLine();
                System.out.println("Enter the year published:");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter serial number:");
                String number = scanner.nextLine();
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                // Creates a new Book object with the user inputs
                Book b1 = new Book(title, author, year, number,quantity);
                // adds the book
                store.addBook(b1);
            }
            // Remove a book from the bookstore
            else if (choice == 2) {
                System.out.println("-----------------------------Removing book-----------------------------");
                System.out.println("-----------------------------Current book list-----------------------------");
                System.out.println(store.bookStoreBookInfo());
                // Prompts the user to enter the title of the book to remove
                System.out.println("Enter title of the book:");
                String title = scanner.nextLine();
                // Searches for the book by title and removes it
                for (int j = 0; j < store.getBooks().length; j ++) {
                    if (store.getBooks()[j].getTitle().equals(title)) {
                        store.removeBook(store.getBooks()[j]);
                        break;
                    }
                }
                System.out.println("-----------------------------Book removed-----------------------------");
            }
            else if (choice == 3) {
                // Insert a book at a specific index in the bookstore
                System.out.println("-----------------------------Inserting book-----------------------------");
                // Asks the user for the info
                System.out.println("Enter title of the book:");
                String title = scanner.nextLine();
                System.out.println("Enter name of the author:");
                String author = scanner.nextLine();
                System.out.println("Enter the year published:");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter serial number:");
                String number = scanner.nextLine();
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                // creates the new book
                Book b1 = new Book(title, author, year, number,quantity);
                System.out.println("-----------------------------Current book list-----------------------------");
                System.out.println(store.bookStoreBookInfo());
                System.out.println("Enter index:");
                int index = scanner.nextInt();
                scanner.nextLine();
                // inserts the new book given the index provided by the user
                store.insertBook(b1, index);
                System.out.println("-----------------------------Book inserted-----------------------------");
            }
            // adds a new user
            else if (choice == 4) {
                System.out.println("-----------------------------Adding user-----------------------------");
                System.out.println("Enter name of user:");
                String name = scanner.nextLine();
                // generates a new user id
                User u1 = new User(name, IdGenerate.getCurrentId());
                IdGenerate.generateID();
                // adds the user
                store.addUser(u1);
                System.out.println("-----------------------------User added-----------------------------");
            }
            // removes a usser
            else if (choice == 5) {
                System.out.println("-----------------------------Removing user-----------------------------");
                // displays the current user list
                System.out.println("-----------------------------Current user list-----------------------------");
                for (int i = 0; i < store.getUsers().length; i ++) {
                    if (store.getUsers()[i] == null) {
                        break;
                    }
                    System.out.println(i + ". " + store.getUsers()[i].userInfo());
                }
                // asks the user for the index
                System.out.println("Enter index of the user:");
                int index = scanner.nextInt();
                scanner.nextLine();
                // removes the user
                store.removeUser(store.getUsers()[index]);
                System.out.println("-----------------------------User removed-----------------------------");
            }
            // displays a user list
            else if (choice == 6) {
                System.out.println("-----------------------------User list-----------------------------");
                // loops through the user list and displays it
                for (int i = 0; i < store.getUsers().length; i ++) {
                    if (store.getUsers()[i] == null) {
                        break;
                    }
                    System.out.println(i + ". " + store.getUsers()[i].userInfo());
                }
            }
            // sets a book to the user
            else if (choice == 7) {
                System.out.println("-----------------------------Setting book to user-----------------------------");
                System.out.println("-----------------------------User list-----------------------------");
                for (int i = 0; i < store.getUsers().length; i ++) {
                    if (store.getUsers()[i] == null) {
                        break;
                    }
                    System.out.println(i + ". " + store.getUsers()[i].userInfo());
                }
                // asks the user for the index of the user they want to modify
                System.out.println("Enter index of the user:");
                int index = scanner.nextInt();
                scanner.nextLine();
                System.out.println("-----------------------------Avaliable books-----------------------------");
                System.out.println(store.bookStoreBookInfo());
                // makes a new book list
                Book[] newBooks = new Book[5];
                System.out.println("Type the index of the book. -1 to end. Only checkout a maximum of 5 books");
                int choice2 = scanner.nextInt();
                scanner.nextLine();
                // loops through the user prompt and sets the book to the index of the copy list
                for (int i = 0; i < 5; i ++) {
                    if (choice2 == -1) {
                        break;
                    }
                    newBooks[i] = store.getBooks()[choice2];
                    store.removeBook(store.getBooks()[i]);
                    System.out.println("-----------------------------Avaliable books-----------------------------");
                    System.out.println(store.bookStoreBookInfo());
                    System.out.println("Type the index of the book. -1 to end. Only checkout a maximum of 5 books");
                    choice2 = scanner.nextInt();
                    scanner.nextLine();
                }
                // sets the copy list to the user's books
                store.getUsers()[index].setBooks(newBooks);
                System.out.println("-----------------------------Books set-----------------------------");
            }
            // displays the avaliable books
            else if (choice == 8) {
                System.out.println("-----------------------------Avaliable books-----------------------------");
                System.out.println(store.bookStoreBookInfo());
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("1. Add new book\n2. Remove book\n3. Insert book\n4. Add user\n5. Remove user\n6. Print user info\n7. Set book to user\n8. Print library books\n9. End");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

    }
}