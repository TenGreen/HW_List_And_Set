package pro.sky.HVListAndSet.git.exeption;

public class EmployeeAlreadyAddedExeptoin extends RuntimeException{
    public EmployeeAlreadyAddedExeptoin() {
    }

    public EmployeeAlreadyAddedExeptoin(String message) {
        super(message);
    }

    public EmployeeAlreadyAddedExeptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyAddedExeptoin(Throwable cause) {
        super(cause);
    }

    public EmployeeAlreadyAddedExeptoin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
