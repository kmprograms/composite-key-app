package com.app.model;

import com.app.dto.OrderDto;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @EmbeddedId
    private OrderIdentity orderIdentity;

    private String description;
    private BigDecimal price;
    private Integer quantity;

    public OrderDto toDto() {
        return OrderDto.builder()
                .description(description)
                .price(price)
                .quantity(quantity)
                .build();
    }

}
