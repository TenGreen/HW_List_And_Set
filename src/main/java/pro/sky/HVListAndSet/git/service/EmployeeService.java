package pro.sky.HVListAndSet.git.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.HVListAndSet.git.Employee;
import pro.sky.HVListAndSet.git.exeption.EmployeeAlreadyAddedExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeNotFoundExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeStorageIsFullExeptoin;
import pro.sky.HVListAndSet.git.exeption.InvalidDataExeption;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private static final int MAX_SIZE = 5;

    public void add(Employee actual) {
        if (!StringUtils.isAlpha(actual.getFirstName()) || !StringUtils.isAlpha(actual.getLastName())) {
            throw new InvalidDataExeption();
        }
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullExeptoin();
        }
        if (employees.containsKey(createCey(actual.getFirstName(), actual.getLastName()))) {
            throw new EmployeeAlreadyAddedExeptoin();
        }
        correctCase(actual);
        employees.put(createCey(actual.getFirstName(), actual.getLastName()), actual);


    }

    public Employee add(String firstName, String lastName, int department, double salary) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new InvalidDataExeption();
        }
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullExeptoin();
        }
        Employee employeeToAdd = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(createCey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedExeptoin();
        }
        correctCase(employeeToAdd);
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
        //return List.copyOf(employees.values());
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    private String createCey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }

    private static void correctCase(Employee employee) {
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName().toLowerCase()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName().toLowerCase()));
    }
}
