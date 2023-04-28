package com.geekster.UserManagementSystemValidations11.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class User {

    @NotEmpty
    private String userId;
    @NotNull
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth should be in the format yyyy-MM-dd")
    private String dateOfBirth;
    @Email
    private String email;

    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in the format XX-XXXXXXXXXX")
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message="Date should be in format dd/mm/yyyy")
    private String date;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Time should be in the format HH:mm:ss")
    private String time;



}
