package com.example.hotelreservationsystemwithspringboot.sahinHotel.service;

import com.example.hotelreservationsystemwithspringboot.sahinHotel.model.Customer;
import com.example.hotelreservationsystemwithspringboot.sahinHotel.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yilmazsahin
 * @since 1/4/2024
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not fount with id : " + id));
        existingCustomer.setFullName(updatedCustomer.getFullName());
        existingCustomer.setDescription(updatedCustomer.getDescription());
        existingCustomer.setBirthDate(updatedCustomer.getBirthDate());
        existingCustomer.setIdentityNumber(updatedCustomer.getIdentityNumber());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        return customerRepository.save(existingCustomer);
    }

    public Customer partialUpdateCustomer(Long id, Map<String, Object> updates) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not fount with id : " + id));
        if (updates.containsKey("fullName")) {
            existingCustomer.setFullName((String) updates.get("fullName"));
        }
        if (updates.containsKey("identityNumber")) {
            existingCustomer.setIdentityNumber((String) updates.get("identityNumber"));
        }
        if (updates.containsKey("phoneNumber")) {
            existingCustomer.setPhoneNumber((String) updates.get("phoneNumber"));
        }
        if (updates.containsKey("birthDate")) {
            existingCustomer.setBirthDate((Date) updates.get("birthDate"));
        }
        if (updates.containsKey("description")) {
            existingCustomer.setDescription((String) updates.get("description"));
        }
        return customerRepository.save(existingCustomer);
    }
}
