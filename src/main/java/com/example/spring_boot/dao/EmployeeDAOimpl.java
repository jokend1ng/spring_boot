package com.example.spring_boot.dao;


import com.example.spring_boot.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;


    @Override
    public List getAllEmployees() {
        Query query = entityManager.createQuery("from Employee ");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);

    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("DELETE from Employee " + "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
