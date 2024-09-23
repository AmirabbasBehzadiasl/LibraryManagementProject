package Exceptions;

public class RentBookException extends Exception{
    public RentBookException(){
        super.getCause();
    }
    public RentBookException(String massage){
        super(massage);
    }
}
