package services;

import api.HotelResource;
import models.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomerService  {
    private static CustomerService instance = null;
    private static Map<String, Customer> customers;
    public static CustomerService Instance(){
        if(Objects.isNull(instance)){
            customers = new HashMap<>();
            instance = new CustomerService();
        }
        return instance;
    }

    public void createCustomer(String email, String firstName, String lastName) {
        Customer newCustomer = new Customer(email, firstName, lastName);
        customers.put(newCustomer.getEmail(), newCustomer);
    }

    public Customer getCustomerDetail(String email) {
        return customers.get(email);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
