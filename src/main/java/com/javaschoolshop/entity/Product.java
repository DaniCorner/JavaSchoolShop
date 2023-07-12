package com.javaschoolshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javaschoolshop.entity.ProductCategory;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private ProductCategory category;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "weight")
    private int weight;

    @Column(name = "volume")
    private int volume;
}
