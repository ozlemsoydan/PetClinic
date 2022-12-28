package com.ozlemaglar.petClinic.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T>{
    private T data;
    private String message;
    private Integer code;

}
