import sun.jvm.hotspot.code.SingletonBlob;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Objects;

public class Library {
    private static Library instance= null;
    private String name;
    private static Hashtable<User, LinkedList<Book>> information;

    private Library(String name) {
        this.name = name;
        information = new Hashtable<>();
    }
    public static synchronized Library getInstance(String name){
        if (instance == null)
            instance = new Library(name);

        return instance;
    }


    public static Hashtable<User, LinkedList<Book>> getInformation() {
        return information;
    }


    public static void setInformation(Hashtable<User, LinkedList<Book>> information) {
        Library.information = information;
    }

    public String getName() {
        return name;
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
        if (book.getInUseBy()!=null){
            if (Objects.equals(book.getInUseBy(), user.getName())) {
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
        book.setInUseBy(user.getName());
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
        book.setInUseBy(null);
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

        int count = 1 ;
    public  void getUsers(){
        for (User user : Library.information.keySet())
            System.out.print(count++ +"_ "+user.getName()+"\t");
        System.out.println();
    }
    public void getBooks(){
        int count = 1 ;
        for (Book book : Book.getBooks())
            System.out.print(count++ +"_ "+book.getName()+"\t");
        System.out.println();
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
    private static void merging(int low, int mid, int high, String[] array){
        int length = array.length;
        String tempArray[] = new String[length];
        int l1, l2, i;
        for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
            if(array[l1].compareTo(array[l2])<0)
                tempArray[i] = array[l1++];
            else
                tempArray[i] = array[l2++];
        }
        while(l1 <= mid)
            tempArray[i++] = array[l1++];
        while(l2 <= high)
            tempArray[i++] = array[l2++];
        for(i = low; i <= high; i++)
            array[i] = tempArray[i];
    }
    private static void mergeSort(String[] array, int low, int high){
        int mid;
        if(low < high) {
            mid = (low + high) / 2;
            mergeSort(array,low, mid);
            mergeSort(array,mid+1, high);
            merging(low, mid, high,array);
        }
    }
    public void searchUser(String string){
        for (User user : information.keySet()){
            if (user.getName().equals(string)||user.getID().equals(string)||user.getNationalCode().equals(string)){
                System.out.println(user);
                return;
            }
        }
        System.out.println("your user not exist");
    }

    public void searchBook(String string){
        for (Book book : Book.getBooks()){
            if (book.getName().equals(string)||book.getGenre().equals(string)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("your book not exist");
    }
    public void searchUserByName(String name){
        int i = 0;
        String[] string = new String[information.size()];
        for (User user : information.keySet())
            string[i++]=user.getName();
        if (exponentialSearch(string, string.length, name)){
           for (User user : information.keySet())
            if (user.getName().equals(name)) {
                System.out.println(user);
                return;
            }
        }
            else System.out.println("your user not exist");
    }

    public void searchUserByID(String id){
        int i = 0;
        String[] string = new String[information.size()];
        for (User user : information.keySet())
            string[i++]=user.getID();
        if (exponentialSearch(string, string.length, id)){
          for (User user : information.keySet())
             if (user.getID().equals(id)){
                System.out.println(user);
                return;
            }
        }
        else System.out.println("your user not exist");
    }
    public void searchBookByName(String name){
        int i = 0;
        String[] string = new String[Book.getBooks().size()];
        for (Book book : Book.getBooks())
            string[i++]=book.getName();
        if (exponentialSearch(string, string.length, name)){
             for (Book book : Book.getBooks())
                 if (book.getName().equals(name)){
                     System.out.println(book);
                     return;
                 }
            }
        else System.out.println("your book not exist");

    }
    private static boolean binarySearch(String[] Array, String item, int low, int high) {
        mergeSort(Array,low, high);
        while (low <= high) {
            int middle = (high + low) / 2;
            if (Array[middle].equals(item))
                return true;
            else if (Array[middle].compareTo(item)<0) {
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return false;
    }
    public static boolean exponentialSearch(String[] array, int size, String item) {
        mergeSort(array,0, array.length-1);
        int i = 1;
        if (array[0].equals(item))
            return true;
        while (i < size && array[i].compareTo(item)<=0)
            i *= 2;
        return binarySearch(array, item, i / 2, Math.min(i, size - 1));
    }
}
