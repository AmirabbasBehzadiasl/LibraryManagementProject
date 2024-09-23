package Exceptions;

public class NullException extends Exception{
    public NullException(){
        super.getCause();
    }
    public NullException(String string){
        super(string);
    }
}
