package com.johnson.interswitch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "tbl_invetory_transaction")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Double amount;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "cartId", referencedColumnName = "id")
    private UserCart cart;

    @CreatedDate
    private LocalDateTime createdAt;
}
