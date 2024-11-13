package com.aradhana.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date relesedate;
    private boolean avaliable;
    private int quantity;
    private String imagename;
    private String imagetype;
    @Lob
    private byte[] imagedate;

}
