// package com.example.springBootCrud;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;

// import com.example.springBootCrud.model.Customer;
// // import com.example.springBootCrud.repository.CustomerRepository;
// import com.example.springBootCrud.service.CustomerService;
// import java.util.List;
// import org.springframework.ui.Model;

// // NOTES
// // ----
// // @Controller: Used when you return HTML views using Thymeleaf (e.g.,
// customers.html in resources/templates).

// // model.addAttribute(...): Sends data to your HTML view.

// // The return "customers" tells Spring to render customers.html.

// @Controller
// public class CustomerController {

// private final CustomerService customerService;

// public CustomerController(CustomerService customerService) {
// this.customerService = customerService;
// }

// @GetMapping("/customers")
// public String getAllCustomers(Model model) {
// List<Customer> customerList = customerService.getAllCustomers();
// model.addAttribute("customers", customerList);
// return "customers"; // returns customers.html from templates folder
// }
// }

// // private final CustomerRepository customerRepository;
