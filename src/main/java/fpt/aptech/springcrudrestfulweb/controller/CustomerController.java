package fpt.aptech.springcrudrestfulweb.controller;

//import antlr.collections.List;
import fpt.aptech.springcrudrestfulweb.entity.Customer;
import fpt.aptech.springcrudrestfulweb.exception.ResourceNotFoundException;
import fpt.aptech.springcrudrestfulweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.*;

//import java.awt.*;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //create get all customer api
    @GetMapping("/customers")
   public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //create employee
    @PostMapping("/customer")
    public  Customer createCustomer(@RequestBody Customer customer){
        return  customerRepository.save(customer);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") long id) throws  ResourceNotFoundException{
        Customer customer =  customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found for Id"+id));
        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") long id, @RequestBody Customer customerDetail) throws  ResourceNotFoundException{
        Customer customer =  customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found for Id"+id));
        customer.setLastName(customerDetail.lastName);
        customer.setFirstName(customer.firstName);
        customer.setEmail(customer.email);
        customerRepository.save(customer);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") long id) throws  ResourceNotFoundException{
        Customer customer =  customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer not found for Id"+id));
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
