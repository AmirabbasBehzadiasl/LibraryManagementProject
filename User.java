import Exceptions.NationalCodeException;
import Exceptions.NullException;
import Exceptions.NumberFormatException;
import Exceptions.RentBookException;
import Exceptions.StringLengthException;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class User {
    private static List<User> users = new LinkedList<>();
    private static int counterUser = 0;
    private String fullName;
    private String nationalCode;
    private String id;
    private List<Book> rentedBooks;
    private byte countOfRentingBook = 0;
    private String[] renting;
    public User() {
        this.id = null;
        this.rentedBooks = new LinkedList<>();
        this.renting = new String[3];
    }
    public String[] getRenting() {
        return this.renting;
    }

    public void setRenting(String[] renting) {
        this.renting = renting;
    }

    public byte getCountOfRentingBook() {
        return this.countOfRentingBook;
    }

    public void setCountOfRentingBook(byte countOfRentingBook) throws RentBookException {
        if (countOfRentingBook>3)
            throw new RentBookException();
        this.countOfRentingBook = countOfRentingBook;
    }

    public LinkedList<Book> getRentedBooks() {
        return  (LinkedList<Book>)this.rentedBooks;
    }

    public void setRentedBooks(LinkedList<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public static int getCounterUser() {
        return counterUser;
    }

    public static void setCounterUser(int counterUser) {
        User.counterUser = counterUser;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) throws StringLengthException, NullException {
        if (fullName==null)
            throw new NullException();
        if (fullName.length()<6||fullName.length()>60)
            throw new StringLengthException("it's so short");
        this.fullName = fullName;
    }

    public String getNationalCode() {
        return this.nationalCode;
    }

    public void setNationalCode(String nationalCode) throws NationalCodeException, NullException, NumberFormatException {
        if (nationalCode==null)
            throw new NullException();
        if (Pattern.matches("[0-99999999999]+", nationalCode) == false)
            throw new NumberFormatException();
        if (nationalCode.length()<10)
            throw new NationalCodeException();
        this.nationalCode = nationalCode;
    }

    public String getID() {
        return this.id;
    }

    public void setID() {
        this.id = ""+LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+counterUser;
    }

    public static void create(String name , String nationalCode ) throws NationalCodeException, StringLengthException, NullException, NumberFormatException {
        User user = new User();
        users.add(user);
        user.setFullName(name);
        user.setNationalCode(nationalCode);
    }
    public static void loadAllUsers(){
        Iterator<User> userIterator = users.iterator();
        int i = 0;
        while (userIterator.hasNext())
            System.out.print(++i + ": " + userIterator.next().fullName + " ");
        System.out.println();
    }
    public static void loadUser(String name){
        Iterator<User> userIterator = users.iterator();
        while(userIterator.hasNext()) {
            User s = userIterator.next();
            if (s.fullName.equals(name)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("not found");
    }
    public static void updateName(String nationalCode, String newName) throws StringLengthException, NullException {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (Objects.equals(user.nationalCode, nationalCode)){
                user.setFullName(newName);
                return;
            }
        }
            System.out.println("this user not exist");
    }
    public static void updateNationalCode(String nationalCode, String newNC) throws NationalCodeException, NullException, NumberFormatException {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (Objects.equals(user.nationalCode, newNC)){
                user.setNationalCode(newNC);
                return;
            }
            System.out.println("this user not exist");
        }
    }
    public static void delete(String userName){
        for (User user : users )
            if (user.fullName.equals(userName)){
                users.remove(user);
                return;
            }
        System.out.println("Invalid user");
    }
    public static void searchUser(String string){
        for (User user : Library.getInformation().keySet()){
            if (user.getFullName().equals(string)||user.getID().equals(string)||user.getNationalCode().equals(string)){
                System.out.println(user);
                return;
            }
        }
        System.out.println("your user not exist");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.fullName + '\'' +
                ", nationalCode='" + this.nationalCode + '\'' +
                ", ID='" + this.id + '\'' +
                ", rentedBooks=" + this.rentedBooks +
                ", countOfRentingBook=" + this.countOfRentingBook +
                ", renting=" + Arrays.toString(this.renting) +
                '}';
    }
}
