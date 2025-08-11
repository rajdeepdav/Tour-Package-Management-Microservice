package com.example.tourbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String discountInPercentage;

    @com.example.tourbackend.entity.NotBlank
    private String title;

    private String description;
    private String duration;
    private String actualPrice;
    private String discountedPrice;
    private String location;
}

