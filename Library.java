import Exceptions.NullException;
import Exceptions.RentBookException;
import Exceptions.StringLengthException;
import java.util.Objects;
import static Search.Search.mergeSort;

public class Library {
    private static String name;

    public Library(String name) throws StringLengthException, NullException {
        if (name==null)
            throw new NullException();
        if (name.length()<5)
            throw new StringLengthException();
        Library.name = name;
    }

    public String getName() {
        return Library.name;
    }

    public void setName(String name) throws NullException, StringLengthException {
        if (name==null)
            throw new NullException();
        if (name.length()<5)
            throw new StringLengthException();
        Library.name = name;
    }

    public void rentBook(Book book, User user) throws NullException, RentBookException {
        if (!User.getUsers().contains(user)) {
            System.out.println("You must register first");
            return;
        }
        if (!Book.getBooks().contains(book)){
            System.out.println("this book not exist");
            return;
        }
        if (book.getUserRentingThisBook()!=null){
            if (book.getUserRentingThisBook().getUserName().equals(user.getUserName())){
                System.out.println("You already have this book");
                return;
            }
            System.out.println("Hi " + user.getUserName() +" this book rented before");
            return;
        }
        byte count = user.getCountOfRentingBook();
        user.getRenting()[count++]= book.getName();
        user.setCountOfRentingBook(count);
        user.setRentedBooks(book.getName());
        book.setUserRentingThisBook(user);
        book.getUsersRentedThisBook().add(user);
        System.out.println(user.getUserName() + " you successfully rent " + book.getName());
        System.out.println("You can borrow " + (3-user.getCountOfRentingBook()) + " more books");
    }

    public static User getUserByNationalCode(String nationalCode){
        for (User user : User.getUsers())
            if (user.getNationalCode().equals(nationalCode)){
                return user;
            }

        return null;
    }
    public static Book getBookByName(String bookName){
        for (Book book : Book.getBooks())
            if (bookName.equals(book.getName()))
                 return book;

        return null;
    }

    public void returnBook(Book book,User user) throws RentBookException, NullException {
        if (!user.getRentedBooks().contains(book)){
            System.out.println("you didn't rent this book yet");
            return;
        }
        if (!User.getUsers().contains(user)){
            System.out.println("invalid user");
            return;
        }
        book.setUserRentingThisBook(null);
        for (int i = 2 ; i >= 0 ; i--){
            if (Objects.equals(user.getRenting()[i], book.getName())) {
                if (i == 2){
                    user.getRenting()[i] = null;
                    break;
                }
                user.getRenting()[i] = user.getRenting()[i + 1];
            }
        }
        System.out.println(user.getUserName()+  " you return " + book.getName());
        byte count = user.getCountOfRentingBook();
        user.setCountOfRentingBook(--count);
        System.out.println("you can rent " + (3 - user.getCountOfRentingBook()) + " more books");
    }

    public void sortUser(String sortBy){
        int i = 0;
        String[] array = new String[User.getUsers().size()];
        switch (sortBy){
            case "id" :
                for (User user : User.getUsers())
                    array[i++]=user.getID();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                 break;
            case "name" :
                for (User user : User.getUsers())
                    array[i++]=user.getUserName();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                break;
            case "nationalCode":
                for (User user : User.getUsers())
                    array[i++]=user.getNationalCode();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                break;
            default:
                System.out.println("Invalid input . You must enter (id/name/nationalCode) ");
        }
    }

    public void sortBook(String sortBy){
        int i = 0;
        String[] array = new String[Book.getBooks().size()];
        switch (sortBy){
            case "name" :
                for (Book book : Book.getBooks())
                    array[i++]=book.getName();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                break;
            case "genre":
                for (Book book : Book.getBooks())
                    array[i++]=book.getGenre();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                break;
            default:
                System.out.println("Invalid input . You must enter (name/genre) ");
        }
    }

    private void printArray(String[] array){
        int count = 1 ;
        for (String string : array) System.out.print(count++ +": "+ string+" ");
        System.out.println();
    }

    public static void load(){
        System.out.println(Library.name+" library have " + User.getUsers().size() + " user and " + Book.getBooks().size() + " book");
    }

    public static void updateName( String newName){
        Library.name=newName;
    }

}

