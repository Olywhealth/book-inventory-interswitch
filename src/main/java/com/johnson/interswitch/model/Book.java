package com.johnson.interswitch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.johnson.interswitch.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnson on 16/12/2023
 */
@Entity
@Setter
@Getter
@Table(name = "tbl_invetory_book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private Genre genre;
  private double price;
  private String isbn;
  private String author;
  private String yearOfPublication ;
  @JoinColumn(name = "cart_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  @JsonBackReference
  private UserCart cart;

}
