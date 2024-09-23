import java.time.LocalDate;
import java.util.*;

public class User {
    private static List<User> users = new LinkedList<>();
    private static int counterUser = 0;
    private String name;
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

    public void setCountOfRentingBook(byte countOfRentingBook) {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCode() {
        return this.nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getID() {
        return this.id;
    }

    public void setID() {
        this.id = ""+LocalDate.now().getYear()+LocalDate.now().getMonthValue()+LocalDate.now().getDayOfMonth()+counterUser;
    }

    public static void create(String name , String nationalCode ){
        User user = new User();
        users.add(user);
        user.setName(name);
        user.setNationalCode(nationalCode);
    }
    public static void loadAllUsers(){
        Iterator<User> userIterator = users.iterator();
        int i = 0;
        while (userIterator.hasNext())
            System.out.print(++i + ": " + userIterator.next().name + " ");
        System.out.println();
    }
    public static void loadUser(String name){
        Iterator<User> userIterator = users.iterator();
        while(userIterator.hasNext()) {
            User s = userIterator.next();
            if (s.name.equals(name)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("not found");
    }
    public static void updateName(String nationalCode, String newName){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (Objects.equals(user.nationalCode, nationalCode)){
                user.setName(newName);
                return;
            }
        }
            System.out.println("this user not exist");
    }
    public static void updateNationalCode(String nationalCode, String newNC){
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
            if (user.name.equals(userName)){
                users.remove(user);
                return;
            }
        System.out.println("Invalid user");
    }
    public static void searchUser(String string){
        for (User user : Library.getInformation().keySet()){
            if (user.getName().equals(string)||user.getID().equals(string)||user.getNationalCode().equals(string)){
                System.out.println(user);
                return;
            }
        }
        System.out.println("your user not exist");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.name + '\'' +
                ", nationalCode='" + this.nationalCode + '\'' +
                ", ID='" + this.id + '\'' +
                ", rentedBooks=" + this.rentedBooks +
                ", countOfRentingBook=" + this.countOfRentingBook +
                ", renting=" + Arrays.toString(this.renting) +
                '}';
    }
}
