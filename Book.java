import Exceptions.NullException;
import Exceptions.StringLengthException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Book {
    private static List<Book> books =  new LinkedList<>();
    private String name;
    private Genre genre;
    private User userRentingThisBook;
    private Library library;
    private List<User> usersRentedThisBook;

    public Book() {
        this.usersRentedThisBook = new LinkedList<>();
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBooks(LinkedList<Book> books) {
        Book.books = books;
    }

    public List<User> getUsersRentedThisBook() {
        return this.usersRentedThisBook;
    }

    public void setUsersRentedThisBook(LinkedList<User> usersRentedThisBook) {
        this.usersRentedThisBook = usersRentedThisBook;
    }

    public User getUserRentingThisBook() {
        return this.userRentingThisBook;
    }

    public void setUserRentingThisBook(User userRentingThisBook) {
        this.userRentingThisBook = userRentingThisBook;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String bookName) throws NullException, StringLengthException {
        if(bookName==null)
            throw new NullException();
        if (bookName.length()<5)
            throw new StringLengthException();
        this.name = bookName;
    }

    public String getGenre() {
        return this.genre.toString();
    }

    public void setGenre(Genre genre) throws StringLengthException, NullException {
        if (genre==null)
            throw new NullException();
        if (genre.toString().length()<5)
            throw new StringLengthException();
        this.genre = genre;
    }

    public String getLibrary() {
        return this.library.getName();
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public static void create(String name , Genre genre , Library library) throws StringLengthException, NullException {
        Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setLibrary(library);
        books.add(book);
    }

    public static void loadAllBooks(){
        Iterator<Book> bookIterator = books.iterator();
        int i = 0;
        while (bookIterator.hasNext())
            System.out.print(++i + ": " + bookIterator.next().name + " ");
        System.out.println();
    }

    public static void loadBook(String bookName){
        for (Book book : books) {
            if (book.name.equals(bookName)) {
                System.out.println(book);
                return;
            }
        }
            System.out.println("book eith name ( " + bookName + " ) not exist");
    }

    public static void updateUser(String bookName, User newUser) throws NullException {
        for (Book book : books) {
            if (Objects.equals(book.name, bookName)) {
                book.setUserRentingThisBook(newUser);
                return;
            }
            System.out.println("this book not exist");
        }
    }

    public static void updateName(String bookName, String newName) throws StringLengthException, NullException {
        for (Book book : books) {
            if (Objects.equals(book.name, bookName)) {
                book.setName(newName);
                return;
            }
        }
        System.out.println("book with  name ( " + bookName + " ) not exist");
    }

    public static void deleteBook(String bookName){
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()){
        Book book = bookIterator.next();
            if (book.name.equals(bookName)){
                bookIterator.remove();
                return;
            }
        }
        System.out.println("book with  name ( " + bookName + " ) not exist");
    }

    public static void searchBook(String string){
        for (Book book : books){
            if (book.getName().equals(string)||book.getGenre().equals(string)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("book with  name/genre ( " + string + " ) not exist");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + this.name + '\'' +
                ", genre='" + this.genre + '\'' +
                ", inUseBy='" + this.userRentingThisBook + '\'' +
                ", Library='" + this.library.getName() + '\'' +
                ", rentedBy=" + this.usersRentedThisBook +
                '}';
    }
}
