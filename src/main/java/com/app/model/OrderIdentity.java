package com.app.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.sql.DataSource;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class OrderIdentity implements Serializable {
    private Long productId;
    private Long customerId;
}
