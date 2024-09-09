import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class User {
    private static int counterUser = 0;
    private String name;
    private String nationalCode;
    private String ID;
    private LinkedList<Book> rentedBooks;
    private byte countOfRentingBook = 0;
    private String[] renting;
    public User(String name, String nationalCode) {
        setName(name);
        setNationalCode(nationalCode);
        this.ID = null;
        rentedBooks = new LinkedList<>();
        renting = new String[3];
    }

    public String[] getRenting() {
        return renting;
    }

    public void setRenting(String[] renting) {
        this.renting = renting;
    }

    public byte getCountOfRentingBook() {
        return countOfRentingBook;
    }

    public void setCountOfRentingBook(byte countOfRentingBook) {
        this.countOfRentingBook = countOfRentingBook;
    }

    public LinkedList<Book> getRentedBooks() {
        return rentedBooks;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getID() {
        return ID;
    }

    protected void setID() {
        this.ID = ""+LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+counterUser;
    }

    public void myBook(){
        if (this.countOfRentingBook==0){
            System.out.println(this.getName()+ " you don't have any book");
            return;
        }
        int count = 1 ;
        for (String book : this.renting)
            System.out.print(count++ +"_ "+book+"\t");
        System.out.println();
    }
    public void addUser(){
        int count = User.getCounterUser();
        User.setCounterUser(++count);
        this.setID();
        Library.getInformation().put(this,new LinkedList<>());
    }

    public void removeUser(){
        if (Library.getInformation().containsKey(this)) {
            for (Book book : this.getRentedBooks())
                book.setInUseBy(null);
            Library.getInformation().remove(this);
        }
        else
            System.out.println("Invalid user");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", ID='" + ID + '\'' +
                ", rentedBooks=" + rentedBooks +
                ", countOfRentingBook=" + countOfRentingBook +
                ", renting=" + Arrays.toString(renting) +
                '}';
    }
}
