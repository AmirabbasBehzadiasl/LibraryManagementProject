
public class Main {
    public static  void main(String[] args) {
        Library library =new Library("22Bahman");
        User user3 =new User("reza","1514419");
        User user4 =new User("hossein","145105");
        User user2 =new User("kamran","241565");
        User user =new User("amir","05789635");
        User user1 =new User("babak","14965204");
        library.addUser(user3);
        library.addUser(user4);
        library.addUser(user2);
        library.addUser(user);
        library.addUser(user1);
        Book book = new Book("heart","Love", "22Bahman");
        Book book1 = new Book("the 5 Am Club","Psychology","22Bahman");
        Book book2 = new Book("wolves","Animals","22Bahman");
        Book book3 = new Book("you can do it","Psychology","22Bahman");
        library.addBook(book1); 
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book);
        library.searchUserByName("babak");
        library.searchBookByName("heart");
        }
    }



