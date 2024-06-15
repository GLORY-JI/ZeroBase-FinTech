package com.zerobase.fintech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, length = 20)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(precision = 15, scale = 0)
    private BigDecimal balance;

}
