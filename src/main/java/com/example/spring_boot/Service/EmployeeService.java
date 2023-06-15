package com.example.spring_boot.Service;




import com.example.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmloyee(int id);
    public void deleteEmployee(int id);
}
