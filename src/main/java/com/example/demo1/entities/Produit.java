package com.example.demo1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    private Long id;
    private String name ;
    private double price;
}
