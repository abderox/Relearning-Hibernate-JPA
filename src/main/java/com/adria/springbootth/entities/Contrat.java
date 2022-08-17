package com.adria.springbootth.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrat {
    @GeneratedValue(strategy = GenerationType.TABLE) @Id
    @Column(name = "id_contrat")
    private Long id;
    @NotBlank
    private String title;
    @DecimalMin("100") @DecimalMax("100000")
    private double amount;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_souscription;
    @NotBlank
    private String client;
    @NotNull
    private boolean cloture;
}
