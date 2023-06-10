package pro.sky.HVListAndSet.git.service;

import org.springframework.stereotype.Service;
import pro.sky.HVListAndSet.git.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static final int MAX_SIZE = 5;

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee remove(Employee employee) {
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (firstName.equalsIgnoreCase(employee.getFirstName())
                    && lastName.equalsIgnoreCase(employee.getLastName())) {
                return employee;
            }

        }
        return

    }
}
