package Exceptions;

public class StringLengthException extends Exception{
    public StringLengthException(){
        super.getCause();
    }
    public StringLengthException(String string){
        super(string);
    }
}
