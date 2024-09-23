import Exceptions.NullException;
import Exceptions.StringLengthException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Book {
    private static List<Book> books =  new LinkedList<>();
    private String name;
    private String genre;
    private User using;
    private Library library;
    private List<User> rentedBy;

    public Book() {
        this.rentedBy = new LinkedList<>();
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void setBooks(LinkedList<Book> books) {
        Book.books = books;
    }

    public List<User> getRentedBy() {
        return this.rentedBy;
    }

    public void setRentedBy(LinkedList<User> rentedBy) {
        this.rentedBy = rentedBy;
    }

    public User getUsing() {
        return this.using;
    }

    public void setUsing(User using) throws NullException {
        if (using==null)
            throw new NullException();
        this.using = using;
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
        return this.genre;
    }

    public void setGenre(String genre) throws StringLengthException, NullException {
        if (genre==null)
            throw new NullException();
        if (genre.length()<5)
            throw new StringLengthException();
        this.genre = genre;
    }

    public String getLibrary() {
        return this.library.getName();
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public static void create(String name , String genre , Library library) throws StringLengthException, NullException {
        Book book = new Book();
        books.add(book);
        book.setName(name);
        book.setGenre(genre);
        book.setLibrary(library);
    }
    public static void loadAllBooks(){
        Iterator<Book> bookIterator = books.iterator();
        int i = 0;
        while (bookIterator.hasNext())
            System.out.print(++i + ": " + bookIterator.next().name + " ");
        System.out.println();
    }
    public static void loadBook(String bookName){
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            Book s = bookIterator.next();
            if (s.name.equals(bookName)) {
                System.out.println(s);
                return;
            }
        }
            System.out.println("not found");
    }
    public static void updateUser(String bookName, User newUser) throws NullException {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book s = iterator.next();
            if (Objects.equals(s.name, bookName)){
                s.setUsing(newUser);
                return;
            }
            System.out.println("this book not exist");
        }
    }
    public static void updateName(String bookName, String newName) throws StringLengthException, NullException {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book s = iterator.next();
            if (Objects.equals(s.name, bookName)){
                s.setName(newName);
                return;
            }
            System.out.println("this book not exist");
        }
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
        System.out.println("this book not found");
    }
    public static void searchBook(String string){
        for (Book book : books){
            if (book.getName().equals(string)||book.getGenre().equals(string)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("your book not exist");
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + this.name + '\'' +
                ", genre='" + this.genre + '\'' +
                ", inUseBy='" + this.using + '\'' +
                ", Library='" + this.library.getName() + '\'' +
                ", rentedBy=" + this.rentedBy +
                '}';
    }
}
