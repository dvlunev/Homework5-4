package hw54.dao;

import hw54.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Optional<Employee> getEmployeeById(long id);
    List<Employee> getAllEmployeeList();
    void updateEmployeeAgeById(Employee employee);
    void deleteEmployeeById(long id);
}
