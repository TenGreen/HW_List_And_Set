package pro.sky.HVListAndSet.git.service;

import org.springframework.stereotype.Service;
import pro.sky.HVListAndSet.git.Employee;
import pro.sky.HVListAndSet.git.exeption.EmployeeAlreadyAddedExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeNotFoundExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeStorageIsFullExeptoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class  EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_SIZE = 5;

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullExeptoin();
        }
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employees.contains(employeeToAdd)) {
            throw new EmployeeAlreadyAddedExeptoin();
        }
        employees.add(employeeToAdd);
        return employeeToAdd;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeToRemove = new Employee(firstName, lastName);
        if (!employees.contains(employeeToRemove)) {
            throw new EmployeeNotFoundExeptoin();
        }
        employees.remove(employeeToRemove);
        return employeeToRemove;
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (firstName.equalsIgnoreCase(employee.getFirstName())
                    && lastName.equalsIgnoreCase(employee.getLastName())) {
                return employee;
            }
        }
        throw new EmployeeNotFoundExeptoin();
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }
}
