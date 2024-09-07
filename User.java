import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class User {
    protected static int counterUser = 0;
    private String name;
    private String nationalCode;
    private String ID;
    protected LinkedList<Book> rentedBooks;
    protected byte countOfRentingBook = 0;
    protected String[] renting;
    public User(String name, String nationalCode) {
        setName(name);
        setNationalCode(nationalCode);
        this.ID = null;
        rentedBooks = new LinkedList<>();
        renting = new String[3];
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
