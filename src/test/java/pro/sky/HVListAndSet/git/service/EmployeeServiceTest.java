package pro.sky.HVListAndSet.git.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.HVListAndSet.git.Employee;
import pro.sky.HVListAndSet.git.exeption.EmployeeAlreadyAddedExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeNotFoundExeptoin;
import pro.sky.HVListAndSet.git.exeption.EmployeeStorageIsFullExeptoin;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();


    @Test
    void whenFullThenThrowException() {
        for (int i = 0; i < 5; i++) {
            char additionChar = (char) ('a' + i);
            Employee actualEmployee = new Employee("name" + additionChar,
                    "second_name" + additionChar, 1, 1);
            employeeService.add(actualEmployee);
        }
        assertThrows(EmployeeStorageIsFullExeptoin.class,
                () -> employeeService.add("q", "w", 1, 1));
    }

    @Test
    void whenNotUniqThenTrowException() {
        Employee employee = new Employee("name", "family", 1,1);
        employeeService.add(employee);
        assertThrows(EmployeeAlreadyAddedExeptoin.class, () ->
                employeeService.add("name","family", 1,1));


    }

    @Test
    void addPositive() {
        Employee employee = new Employee("name", "second_name", 1,1);
        employeeService.add(employee);
        assertTrue(employeeService.getAll().contains(employee));
    }

    @Test
    void findPositive() {
        Employee employee = new Employee("name", "second_name", 1,1);
        employeeService.add(employee);
        Employee actual = employeeService.find("name", "second_name");
        assertNotNull(actual);
        assertEquals(employee, actual);
    }

    @Test
    void findNegative() {
        Employee employee = new Employee("name", "second_name", 1,1);
        employeeService.add(employee);
        assertThrows(EmployeeNotFoundExeptoin.class, () -> employeeService.find("not_name", "not_last_name"));
    }

    @Test
    void removePositive() {
        Employee employee = new Employee("name", "second_name", 1,1);
        employeeService.add(employee);
        employeeService.remove("name", "second_name");
        assertFalse(employeeService.getAll().contains(employee));
    }

    @Test
    void removeNegative() {
        Employee employee = new Employee("Fname", "Sname", 1,1);
        employeeService.add(employee);
        employeeService.remove(employee.getFirstName(), employee.getLastName());
        Employee actual = employeeService.find("Fname", "Sname");
        assertNull(actual);
    }

}
