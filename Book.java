import java.util.LinkedList;

public class Book {
    private String name;
    private String genre;
    protected  String inUseBy;
    private String Library;
    protected  LinkedList<User> rentedBy;


    public Book(String name, String genre, String library) {
        setName(name);
        setGenre(genre);
        setLibrary(library);
        rentedBy = new LinkedList<>();
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
