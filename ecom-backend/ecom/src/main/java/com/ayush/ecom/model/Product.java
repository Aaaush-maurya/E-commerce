package com.ayush.ecom.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    private Date releaseDate;
    private  boolean productAvailable;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

}
