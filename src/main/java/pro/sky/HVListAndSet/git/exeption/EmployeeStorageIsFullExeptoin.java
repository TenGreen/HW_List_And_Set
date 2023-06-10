package pro.sky.HVListAndSet.git.exeption;

public class EmployeeStorageIsFullExeptoin extends RuntimeException{
    public EmployeeStorageIsFullExeptoin() {
    }

    public EmployeeStorageIsFullExeptoin(String message) {
        super(message);
    }

    public EmployeeStorageIsFullExeptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeStorageIsFullExeptoin(Throwable cause) {
        super(cause);
    }

    public EmployeeStorageIsFullExeptoin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
