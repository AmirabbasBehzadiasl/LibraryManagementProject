import java.util.Scanner;
import Exceptions.NationalCodeException;
import Exceptions.NullException;
import Exceptions.NumberFormatException;
import Exceptions.StringLengthException;

public class Main {
    public static  void main(String[] args) throws StringLengthException, NationalCodeException, NullException, NumberFormatException {
        Scanner in = new Scanner(System.in);
        Library library = new Library("sdcccf");
        library.setName(in.nextLine());
        Library.load();
        User.create("amirabbas", "0391581568");
        User.create("amirReza", "3681593215");
        User.create("aliMohmammadi", "7896541233");
        User.create("amirAli", "7539512586");
        User.create("mahdiHasani", "1478963255");
        User.create("mahdiAkbari", "1478963255");
        Book.create("oneee", "sdfffff",library);
        Book.create("Twooo", "15ff3",library);
        Book.create("Threee", "slffk",library);
        Book.create("Fourrr", "amsff",library);
        Book.loadAllBooks();
        Book.loadBook("four");
        Book.loadBook("Four");
        User.loadAllUsers();
        User.loadUser("amirabbas");
        User.loadUser("amirAli");
        User.updateName("1118888511","ali2");
        User.loadAllUsers();
        Book.updateName("Four", "Four2");
        Book.loadAllBooks();
        Book.deleteBook("one");
        User.delete("amir");
        Book.loadAllBooks();
        User.loadAllUsers();
    }
    }



