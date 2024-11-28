package org.example.apirestvalidation.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.apirestvalidation.validation.ValidContactId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact2 {

    @ValidContactId
    private String id;

    @NotBlank(message="First name is required")
    @Size(min=2, max=50, message="First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message="Last name is required")
    @Size(min=2, max=50, message="Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message="Email is required")
    @Email(message="Email must be valid")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phone;

}
