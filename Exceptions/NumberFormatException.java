package Exceptions;

public class NumberFormatException extends Exception{
    public NumberFormatException(){
        super.getCause();
    }
    public NumberFormatException(String massage){
        super(massage);
    }
}
