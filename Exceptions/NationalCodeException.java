package Exceptions;

public class NationalCodeException extends Exception {
    public NationalCodeException(){
        System.out.println(super.getMessage());
    }
    public NationalCodeException(String string){
        super(string);
    }
}
