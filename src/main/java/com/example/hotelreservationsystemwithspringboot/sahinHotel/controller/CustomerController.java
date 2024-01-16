package com.example.hotelreservationsystemwithspringboot.sahinHotel.controller;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Customer;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Customer result = customerService.updateCustomer(id, updatedCustomer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> partialUpdateCustomer(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Customer result = customerService.partialUpdateCustomer(id, updates);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
