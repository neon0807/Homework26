package com.example.homework26.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import com.example.homework26.entity.Employee;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;
    public EmployeeDAOImpl(EntityManager entityManager ){
        this.entityManager = entityManager;
    }

    @Override
    public List getEmployee() {
        return entityManager.createQuery("FROM Employee").getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {
        Employee newEmploye =  entityManager.merge(employee);
        employee.setId(newEmploye.getId());
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        ((Query) query).setParameter("id", id);
        query.executeUpdate();
    }
}
