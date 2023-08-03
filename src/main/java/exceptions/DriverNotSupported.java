package exceptions;

public class DriverNotSupported extends Exception {
    public DriverNotSupported(String browser){
        super(String.format("browser %s not supported", browser));
    }
}