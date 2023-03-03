package com.example.homework26.srvice;

import com.example.homework26.dao.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import com.example.homework26.entity.Employee;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> getEmployee() {
        return employeeDAO.getEmployee();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
