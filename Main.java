import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = Library.getInstance("22Bahman");
        User user =new User();
        User user4 =new User("hossein","145105");
        User user2 =new User("kamran","241565");
        User user3 =new User("amir","05789635");
        User user1 =new User("babak","14965204");
        user3.addUser();
        user4.addUser();
        user2.addUser();
        user.addUser();
        user1.addUser();
        Book book = new Book("heart","Love", "22Bahman");
        Book book1 = new Book("the 5 Am Club","Psychology","22Bahman");
        Book book2 = new Book("wolves","Animals","22Bahman");
        Book book3 = new Book("you can do it","Psychology","22Bahman");
        book1.addBook();
        book.addBook();
        book3.addBook();
        book2.addBook();
        library.searchBookByName("heart");
        library.searchUserByName("amirr");
        library.searchUserByID(user.getID());
        library.searchUser("145105");
        library.searchBook("Animals");
        library.sortBook("genre");
        library.sortUser("name");
        library.getUsers();
        library.getBooks();
        library.rentBook(book, user);
        library.rentBook(book1, user);
        book2.removeBook();
        library.rentBook(book2, user);
        library.rentBook(book3, user);
        library.returnBook(book2, user);
        user.removeUser();
        library.rentBook(book2, user);
        library.returnBook(book1, user);

        }
    }



