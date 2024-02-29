package com.example.question2.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question2.model.Customer;
import com.example.question2.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> getCustomersByCity(String city) {
        return customerRepo.findByCity(city);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepo.findAll();
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    public Customer updateCustomerPincode(int customerId, int pincode) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setPincode(pincode);
            return customerRepo.save(customer);
        }
        return null;
    }

    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer deleted successfully.";
        }
        return "Customer not found.";
    }

}
