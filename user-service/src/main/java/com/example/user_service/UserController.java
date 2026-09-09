package com.example.user_service;

import com.example.user_service.orders.OrderClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController // This annotation marks the class as a REST controller, which means it will handle HTTP requests and return responses in a RESTful manner
@RequestMapping ("/users") // This annotation specifies the base URL path for all the endpoints in this controller
public class UserController {

    private final OrderClient orderClient;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, OrderClient orderClient) {
        this.userRepository = userRepository;
        this.orderClient = orderClient;
    }

    @PostMapping // This annotation specifies that this method will handle HTTP POST requests to the specified URL path
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // This line saves the user to the database and returns the generated ID as a string
    }
    
    @GetMapping("/{id}") // This annotation specifies that this method will handle HTTP GET requests to the specified URL path, which includes a path variable for the user ID
    public User getUserById(@PathVariable  Long id) { 
        var user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("User not found")); // This line retrieves the user with the specified ID from the database and returns it, or throws an exception if the user does not exist
    
        var orders = orderClient.getOrdersByUserId(id);

       // if (orders != null)
            user.setOrders(orders);
        
        return user;
    }
    
}
