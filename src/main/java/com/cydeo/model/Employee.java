package com.cydeo.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

//    @NotNull  -----> Field should not be null
//    @NotBlank -----> Field should not be ""
//    @NotEmpty -----> Field should not be "    "


    /*
    @NotNull  = @NotNull
    @NotEmpty = @NotNull + @NotEmpty
    @NotBlank = @NotNull + @NotEmpty + @NotBlank
     */


    @NotBlank
    @Size(max = 12, min=2)
    private String firstName;

    @NotBlank
    @Size(max = 12, min=2)
    private String lastName;

    //Thymeleaf accepts yyyy-MM-dd, but LocalDate accepts mm-dd-yyyy - yyyy-dd-mm
    @DateTimeFormat(pattern = "yyyy-MM-dd") // how to format date according to Thymeleaf
    private LocalDate birthday;

    @NotBlank
    @Email
    private String email;

    //  @NotBlank
    //  @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;



}
