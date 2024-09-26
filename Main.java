import java.util.Scanner;
import Exceptions.*;
import Exceptions.NumberFormatException;
// check update user of book class
public class Main {
    public static  void main(String[] args) throws StringLengthException, NationalCodeException, NullException, NumberFormatException, RentBookException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a name for library : ");
        Library library = new Library(in.nextLine());
        System.out.println("1 to exit");
        System.out.println("2: create a user ");
        System.out.println("3: create a book ");
        System.out.println("4: delete a user ");
        System.out.println("5: delete a book ");
        System.out.println("6: rent a book ");
        System.out.println("7: return a book ");
        System.out.println("8: load all books ");
        System.out.println("9: load a books ");
        System.out.println("10: load all users ");
        System.out.println("11: load a user ");
        System.out.println("12: search user ");
        System.out.println("13: search book ");
        System.out.println("14: update user name ");
        System.out.println("15: update national code ");
        System.out.println("16: update book name ");
        System.out.println("17: load library ");
        System.out.println("18: print sorted users ");
        System.out.println("19: print sorted books ");
        System.out.println("20: update library name ");
        here:
        while (true){
            System.out.println("please enter a number : ");
            int number = in.nextInt();
            in.nextLine();
            switch (number){
                case 1:{
                    break here;
                }
                case 2 :{
                    System.out.println("please enter your username ");
                    String userName = in.nextLine();
                    System.out.println("please enter your national code ");
                    String nationalCode = in.nextLine();
                    User.create(userName,nationalCode);
                    break;
                }
                case 3 : {
                    System.out.println("please enter book name ");
                    String bookName = in.nextLine();
                    System.out.println("please choose one of this genre");
                    Genre genre ;
                    for (Genre g : Genre.values() ){
                        System.out.println(g);
                    }
                    Genre genre1 = Genre.getGenre(in.nextLine());
                    Book.create(bookName, genre1,library);
                    break;
                }
                case 4 : {
                    System.out.println("enter your user name");
                    User.delete(in.nextLine());
                    break ;
                }
                case 5 : {
                    System.out.println("enter book name");
                    Book.deleteBook(in.nextLine());
                    break ;
                }
                case 6 : {
                    System.out.println("enter book name");
                    String book = in.nextLine();
                    System.out.println("enter user national code/id");
                    String user = in.nextLine();
                    library.rentBook(Library.getBookByName(book),Library.getUserByNationalCode(user));
                    break ;
                }
                case 7:{
                    System.out.println("enter book name");
                    String book = in.nextLine();
                    System.out.println("enter user national code/id");
                    String user = in.nextLine();
                    library.returnBook(Library.getBookByName(book),Library.getUserByNationalCode(user));
                    break ;
                }
                case 8 : {
                    Book.loadAllBooks();
                    break ;
                }
                case 9:{
                    System.out.println("enter book name : ");
                    String bookName = in.nextLine();
                    Book.loadBook(bookName);
                    break ;
                }
                case 10:{
                    User.loadAllUsers();
                    break ;
                }
                case 11:{
                    System.out.println("enter your user name");
                    String userName = in.nextLine();
                    User.loadUser(userName);
                    break ;
                }
                case 12 : {
                    System.out.println("enter nationalCode/ID");
                    String user = in.nextLine();
                    User.searchUser(user);
                    break ;
                }
                case 13:{
                    System.out.println("enter name of book/genre");
                    String book = in.nextLine();
                    Book.searchBook(book);
                    break ;
                }
                case 14 : {
                    System.out.println("enter your national code : ");
                    String nationalCode = in.nextLine();
                    System.out.println("enter your new name : ");
                    String newName = in.nextLine();
                    User.updateUserName(nationalCode,newName);
                    break ;
                }
                case 15 : {
                    System.out.println("enter your previous national code : ");
                    String nationalCode = in.nextLine();
                    System.out.println("enter your new national code : ");
                    String newNationalCode = in.nextLine();
                    User.updateNationalCode(nationalCode, newNationalCode);
                    break ;
                }
                case 16 : {
                    System.out.println("enter your previous book name");
                    String previousName = in.nextLine();
                    System.out.println("enter your previous new name");
                    String newName = in.nextLine();
                    Book.updateName(previousName, newName);
                    break ;
                }
                case 17 : {
                    Library.load();
                    break ;
                }
                case 18 : {
                    System.out.println("sort by name/id/national code(enter lower case) ? ");
                    String string = in.nextLine();
                    library.sortUser(string);
                    break ;
                }
                case 19 : {
                    System.out.println("sort by name/genre(enter lower case) ? ");
                    String string = in.nextLine();
                    library.sortBook(string);
                    break ;
                }
                case 20 :{
                    System.out.println("enter new name for your library : ");
                    Library.updateName(in.nextLine());
                    break ;
                }

            }
        }
        System.out.println("finish");

    }
}