package com.muchiri.plainjdbc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muchiri.plainjdbc.domain.Customer;
import com.muchiri.plainjdbc.service.CustomerService;

@Controller
@ResponseBody
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "{name}/{yob}", produces = "application/json")
    public ResponseEntity<Customer> create(@PathVariable("name") String name, @PathVariable("yob") Integer yob) {
        return new ResponseEntity<Customer>(customerService.create(name, yob), HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }
}
