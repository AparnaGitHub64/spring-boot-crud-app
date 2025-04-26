package com.example.springBootCrud.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springBootCrud.model.Customer;
// import com.example.springBootCrud.repository.CustomerRepository;
import com.example.springBootCrud.service.CustomerService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// NOTES
// ----
// @Controller: Used when you return HTML views using Thymeleaf (e.g., customers.html in resources/templates).

// model.addAttribute(...): Sends data to your HTML view.

// The return "customers" tells Spring to render customers.html.

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // http://localhost:8080/customers
    // this method returns a String object
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customers", customerList);
        return "customers"; // returns customers.html from templates folder
    }

    @GetMapping("/customers/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer"; // returns add-customer.html from templates folder
    }

    // @PostMapping("/customers/save")
    // public String saveCustomer(@Valid @ModelAttribute("customer") Customer
    // customer,
    // RedirectAttributes redirectAttributes,
    // BindingResult bindingResult) {
    // if (bindingResult.hasErrors()) {
    // System.out.println("Binding errors occurred: " +
    // bindingResult.getAllErrors()); // Debug log
    // return "add-customer"; // Return to the form if there are errors
    // }
    // customerService.saveCustomer(customer); // Make sure this is implemented
    // redirectAttributes.addFlashAttribute("successMessage", "Customer added
    // successfully!");
    // System.out.println("Success message set: Customer added successfully!"); //
    // Debug log
    // return "redirect:/customers";
    // }

    @PostMapping("/customers/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        // Make sure the BindingResult comes after @Valid
        if (bindingResult.hasErrors()) {
            // Log the errors for debugging purposes
            System.out.println("Binding errors occurred: " + bindingResult.getAllErrors());
            return "add-customer"; // Return the view with errors
        }

        customerService.saveCustomer(customer); // Save the customer if no validation errors
        redirectAttributes.addFlashAttribute("successMessage", "Customer added successfully!");
        System.out.println("Customer saved successfully!"); // Success log
        return "redirect:/customers"; // Redirect after saving
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable("id") Long id, Model model) {
        // Fetch customer by ID from the service
        Customer customer = customerService.getCustomerById(id).orElse(null);

        // Debugging print statement
        System.out.println("Fetching customer with ID: " + id);

        // Check if customer is null
        if (customer == null) {
            System.out.println("Customer not found with ID: " + id);
            // You can handle the case where the customer doesn't exist
            return "redirect:/customers"; // Redirect to customers list page (or show an error page)
        }

        // If customer exists, add to model
        System.out.println("Customer found: " + customer.getFirstName() + " " + customer.getLastName());
        model.addAttribute("customer", customer);

        // Return the view name for editing the customer
        return "add-customer"; // Ensure this matches the correct template for the edit form
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id); // Using deleteCustomer instead of deleteCustomerById
        redirectAttributes.addFlashAttribute("successMessage", "Customer deleted successfully!");
        return "redirect:/customers"; // Redirect to the customers list after deletion
    }

}

// private final CustomerRepository customerRepository;
