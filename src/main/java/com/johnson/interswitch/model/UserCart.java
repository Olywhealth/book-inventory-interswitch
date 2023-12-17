package com.johnson.interswitch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnson on 16/12/2023
 */
@Entity
@Setter
@Getter
@Table(name = "tbl_invetory_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_Id" , referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}
