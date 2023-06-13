package pro.sky.HVListAndSet.git.service;

import org.springframework.stereotype.Service;
import pro.sky.HVListAndSet.git.Employee;
import pro.sky.HVListAndSet.git.exeption.EmployeeAlreadyAddedExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeNotFoundExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeStorageIsFullExeptoin;

import java.util.*;

@Service
public class  EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private static final int MAX_SIZE = 5;

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullExeptoin();
        }
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employees.containsKey(createCey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedExeptoin();
        }
        employees.put(createCey(firstName, lastName), employeeToAdd);
        return employeeToAdd;
    }

    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(createCey(firstName, lastName))) {
            throw new EmployeeNotFoundExeptoin();
        }
        return employees.remove(createCey(firstName, lastName));
    }

    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(createCey(firstName, lastName))) {
            throw new EmployeeNotFoundExeptoin();
        }
        return employees.get(createCey(firstName, lastName));
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    private String createCey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }
}
