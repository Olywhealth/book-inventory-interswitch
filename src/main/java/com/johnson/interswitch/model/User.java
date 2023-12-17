package com.johnson.interswitch.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnson on 16/12/2023
 */
@Entity
@Setter
@Getter
@Table(name = "tbl_invetory_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserCart cart;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<TransactionHistory> transactionHistories = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

}
