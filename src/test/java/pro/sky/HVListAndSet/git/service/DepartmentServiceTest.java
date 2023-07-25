package pro.sky.HVListAndSet.git.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.HVListAndSet.git.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceTest {

    public static final Collection EMPLOYEES = Arrays.asList(
            new Employee("ivan", "ivanov", 1, 10000),
            new Employee("Oleg", "Olegovish", 1, 15000),
            new Employee("Olga", "Olegovna", 2, 15000),
            new Employee("Sergey", "Mihailovish", 2, 20000),
            new Employee("Marina", "Sergeevna", 3, 20000)
    );

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    DepartmentService departmentService;

    //  @BeforeEach
    // void init() {
    //     employeeService = Mockito.mock(EmployeeService.class);
    //    departmentService = new DepartmentService(employeeService);
    //}

    // @Test
    // void test() {
    //     Mockito.when(employeeService.getAll()).thenReturn(Arrays.asList(
    //             new Employee("rew", "tre", 1, 1)
    //     ));
    //     System.out.println(departmentService.getAll(1));
    // }
    @BeforeEach
    void init() {
        Mockito.when(employeeService.getAll()).thenReturn((List<Employee>) EMPLOYEES);
    }

    @Test
    void sum() {
        double actual = departmentService.getEmployeesSalarySum(1);
        assertEquals(25000, actual);
    }

    @Test
    void max() {
        Employee actual = departmentService.getEmployeeWithMaxSalary(2);
        assertEquals(20000, actual.getSalary());
    }

    @Test
    void min() {
        Employee actual = departmentService.getEmployeeWithMinSalary(2);
        assertEquals(15000, actual.getSalary());
    }

    @Test
    void getAllByDepartment() {
        List<Employee> actual = departmentService.getAll(3);
        Collection<Employee> excpected = Collections.singleton(
                new Employee("Marina", "Sergeevna", 3, 20000));
        assertIterableEquals(excpected, actual);
    }

    @Test
    void getAll() {
        Map<Integer, List<Employee>> actual = departmentService.getAll();
        Employee sergey = new Employee("Sergey", "Mihailovish", 2, 20000);
        assertTrue(actual.get(3).contains(sergey));
        assertFalse(actual.get(2).contains(sergey));

        assertEquals(3, actual.keySet().size());
    }

}
