package com.harmony.gw.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    private String empNo;

    private String password;
    
    private String empName;

    private String orgCd;

    private String phoneNum;
    
    private String email;
    
    private String position;
    
    private LocalDate hireDate;
    
    private String role;


}
