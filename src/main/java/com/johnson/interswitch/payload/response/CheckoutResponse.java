package com.johnson.interswitch.payload.response;

import com.johnson.interswitch.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CheckoutResponse {

  private List<Book> orderedBooks = new ArrayList<>();
  private double payableAmount;
}
