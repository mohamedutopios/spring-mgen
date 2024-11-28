package org.example.apirestdata.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;


import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message="l'auteur doit avoir un nom")
    @Size(max = 15, min = 3, message="le nom doit entre 3 et 15 caractères")
    private String name;

    @NotBlank(message="l'auteur doit avoir un email")
    @Email(message="Un email valide")
    @Pattern(regexp = ".*\\.com$", message="l'email doit finir par .com")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "author",cascade = CascadeType.REMOVE ,orphanRemoval = true)
    private Set<Book> books;


}
