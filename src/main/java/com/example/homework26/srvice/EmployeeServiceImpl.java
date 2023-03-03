package com.example.homework26.srvice;

import com.example.homework26.dao.EmployeeRepo;
import org.springframework.stereotype.Service;
import com.example.homework26.entity.Employee;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    @Transactional
    public List<Employee> getEmployee() {
       return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}
