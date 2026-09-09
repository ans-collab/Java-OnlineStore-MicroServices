package com.example.user_service.orders;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.*;

/**user RestClient vs RestTemplate
* synchronose, block thread until a response is receveid vs
asynchronous, non blocking, better scalability
simpler app and basic http op vs
*better error handling and performance for high-load scnearios
* **/

@Service 
public class OrderClient {
    private final RestClient restClient;

    public OrderClient(RestClient.Builder builder) {
        this.restClient = builder
            .baseUrl("http://order-service:8080")
            .build();
    }

    public List<OrderDTO> getOrdersByUserId(Long userId) {
        return restClient.get()
            .uri("/orders/{userId}", userId)
            .retrieve()
            .body(new ParameterizedTypeReference<List<OrderDTO>>() {}
           );
    }

}
