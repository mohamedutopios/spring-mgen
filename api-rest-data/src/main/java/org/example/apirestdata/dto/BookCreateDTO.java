package org.example.apirestdata.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDTO {

    @NotBlank(message = "Le titre est requis")
    private String title;
    @NotNull(message = "La reference à un auteur est obligatoire")
    private Long authorId;

}
