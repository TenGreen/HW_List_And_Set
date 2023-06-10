package pro.sky.HVListAndSet.git.exeption;

public class EmployeeNotFoundExeptoin extends RuntimeException{
    public EmployeeNotFoundExeptoin() {
    }

    public EmployeeNotFoundExeptoin(String message) {
        super(message);
    }

    public EmployeeNotFoundExeptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExeptoin(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundExeptoin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
