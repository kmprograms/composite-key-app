package com.app;

import com.app.model.Order;
import com.app.model.OrderIdentity;
import com.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CompositeKeyAppApplication {

    private final OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(CompositeKeyAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> orderRepository.saveAll(List.of(
                Order.builder()
                        .description("ORDER A")
                        .orderIdentity(OrderIdentity.builder().customerId(1L).productId(1L).build())
                        .price(new BigDecimal("200.50"))
                        .quantity(10)
                        .build(),
                Order.builder()
                        .description("ORDER B")
                        .orderIdentity(OrderIdentity.builder().customerId(1L).productId(2L).build())
                        .price(new BigDecimal("300.50"))
                        .quantity(20)
                        .build(),
                Order.builder()
                        .description("ORDER C")
                        .orderIdentity(OrderIdentity.builder().customerId(2L).productId(1L).build())
                        .price(new BigDecimal("400.50"))
                        .quantity(30)
                        .build(),
                Order.builder()
                        .description("ORDER D")
                        .orderIdentity(OrderIdentity.builder().customerId(2L).productId(2L).build())
                        .price(new BigDecimal("500.50"))
                        .quantity(40)
                        .build()
        ));
    }

}
