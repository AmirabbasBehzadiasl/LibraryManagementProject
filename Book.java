import java.util.LinkedList;

public class Book {
    private static LinkedList<Book> books;
    private String name;
    private String genre;
    private   String inUseBy;
    private String Library;
    private   LinkedList<User> rentedBy;


    public Book(String name, String genre, String library) {
        setName(name);
        setGenre(genre);
        setLibrary(library);
        books = new LinkedList<>();
        rentedBy = new LinkedList<>();
    }


    public static LinkedList<Book> getBooks() {
        return books;
    }

    public static void setBooks(LinkedList<Book> books) {
        Book.books = books;
    }

    public LinkedList<User> getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(LinkedList<User> rentedBy) {
        this.rentedBy = rentedBy;
    }

    public String getInUseBy() {
        return inUseBy;
    }

    public void setInUseBy(String inUseBy) {
        this.inUseBy = inUseBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String bookName) {
        this.name = bookName;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getLibrary() {
        return Library;
    }
    public void setLibrary(String library) {
        Library = library;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }
//    public void getBooks(){
//        int count = 1 ;
//        for (Book book : books)
//            System.out.print(count++ +"_ "+book.getName()+"\t");
//        System.out.println();
//    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", inUseBy='" + inUseBy + '\'' +
                ", Library='" + Library + '\'' +
                ", rentedBy=" + rentedBy +
                '}';
    }
}
