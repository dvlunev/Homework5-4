package hw54.dao;

import hw54.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void createEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployeeList();
    void updateEmployeeAgeById(int id, int age);
    void deleteEmployeeById(int id);
}
