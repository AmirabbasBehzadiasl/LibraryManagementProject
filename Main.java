import java.util.Scanner;
import Exceptions.NationalCodeException;
public class Main {
    public static  void main(String[] args) throws NationalCodeException {
        Scanner in = new Scanner(System.in);
//        Library library = Library.getInstance("22Bahman");
//        Book.create("heart", "romantic", library);
//        Book.create("one", "dsf",library );
//        Book.create("two", "dsf",library );
//        Book.create("three", "dsf",library );
//        Book.create("four", "dsf",library );
//        Book.create("five", "dsf",library );
//        library.searchBookByName("heart");
//        library.searchUserByName("amirr");
//        library.searchUserByID(user.getID());
//        library.searchUser("145105");
//        library.searchBook("Animals");
//        library.sortBook("genre");
//        library.sortUser("name");
//        library.getUsers();
//        library.getBooks();
//        Book.loadAllBooks();
//        Book.loadBook("five");
//        Book.deleteBook("three");
//        Book.loadAllBooks();
//        Book.deleteBook("heart");
//        Book.loadAllBooks();
        Library library = new Library("22Bahman");
        Library.load();
        User.create("amir", "153123");
        User.create("amirReza", "4444");
        User.create("ali", "11111");
        User.create("amirAli", "123131132");
        User.create("mahdi", "5648487");
        Book.create("one", "sdf",library);
        Book.create("Two", "153",library);
        Book.create("Three", "slk",library);
        Book.create("Four", "ams",library);
        Book.loadAllBooks();
        Book.loadBook("four");
        Book.loadBook("Four");
        User.loadAllUsers();
        User.loadUser("amirabbas");
        User.loadUser("amirAli");
        User.updateName("11111","ali2");
        User.loadAllUsers();
        Book.updateName("Four", "Four2");
        Book.loadAllBooks();
        Book.deleteBook("one");
        User.delete("amir");
        Book.loadAllBooks();
        User.loadAllUsers();
//        library.rentBook();
        String s = null;
        try {
        if (s==null)
            throw new NationalCodeException("sss");
        }catch (ArrayIndexOutOfBoundsException NCE){
            System.out.println("fff");
        }
        }
    }



