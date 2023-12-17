package com.johnson.interswitch.payload.response;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnson on 16/12/2023
 */
@Getter
@Setter
//@Builder
public class GenericResponse<T> {
  private T data;
  private List<?> error = new ArrayList<>();

}
