import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Objects;
import static Search.Search.mergeSort;

public class Library {
    private static Library instance= null;
    private static String name;
    private static Hashtable<User, LinkedList<Book>> information;

    public Library(String name) {
        Library.name = name;
        information = new Hashtable<>();
    }
    public static Hashtable<User, LinkedList<Book>> getInformation() {
        return information;
    }

    public static void setInformation(Hashtable<User, LinkedList<Book>> information) {
        Library.information = information;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rentBook(Book book, User user){
        if (!information.containsKey(user)) {
            System.out.println("You must register first");
            return;
        }
        if (!Book.getBooks().contains(book)){
            System.out.println("this book not found");
            return;
        }
        if (book.getUsing()!=null){
            if (Objects.equals(book.getUsing(), user.getName())) {
                System.out.println("You already have this book");
                return;
            }
            System.out.println("Hi " + user.getName() +" this book rented before");
            return;
        }
        try {
            byte count = user.getCountOfRentingBook();
            user.getRenting()[count++]= book.getName();
            user.setCountOfRentingBook(count);
        }catch (ArrayIndexOutOfBoundsException e){
             System.out.println("you can't rent a book");
             return;
        }
        book.setUsing(user);
        book.getRentedBy().add(user);
        user.getRentedBooks().add(book);
        information.put(user,user.getRentedBooks());
        System.out.println(user.getName() + " you successfully rent " + book.getName());
        System.out.println("You can borrow " + (3-user.getCountOfRentingBook()) + " more books");
    }

    public void returnBook(Book book,User user){
        if (!user.getRentedBooks().contains(book)){
            System.out.println("you didn't rent this book yet");
            return;
        }
        if (!information.containsKey(user)){
            System.out.println("this user not exist");
            return;
        }
        book.setUsing(null);
        for (int i = 2 ; i >= 0 ; i--){
            if (Objects.equals(user.getRenting()[i], book.getName())) {
                if (i == 2){
                    user.getRenting()[i] = null;
                    break;
                }
                user.getRenting()[i] = user.getRenting()[i + 1];
            }
        }
        System.out.println(user.getName()+  " you return " + book.getName());
        byte count = user.getCountOfRentingBook();
        user.setCountOfRentingBook(--count);
        System.out.println("you can rent " + (3 - user.getCountOfRentingBook()) + " more books");
    }

    public void sortUser(String sortBy){
        int i = 0;
        String[] array = new String[information.size()];
        switch (sortBy){
            case "id" :
                for (User user : information.keySet())
                    array[i++]=user.getID();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                 break;
            case "name" :
                for (User user : information.keySet())
                    array[i++]=user.getName();
                mergeSort(array, 0, array.length-1);
                printArray(array);
                break;
            case "nationalCode":
                for (User user : information.keySet())
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
        System.out.println(Library.name+" library have " + information.size() + " user and " + Book.getBooks().size() + " book");
    }
    public static void updateName( String newName){
        Library.name=newName;
    }
}

