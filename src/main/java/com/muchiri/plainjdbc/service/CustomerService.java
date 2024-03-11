package com.muchiri.plainjdbc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.muchiri.plainjdbc.dao.CustomerDao;
import com.muchiri.plainjdbc.domain.Customer;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer create(String name, Integer yob) {
        try {
            return customerDao.create(name, yob);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
