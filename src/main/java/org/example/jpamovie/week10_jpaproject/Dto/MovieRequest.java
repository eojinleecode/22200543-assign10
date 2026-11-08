package org.example.jpamovie.week10_jpaproject.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Size;

public record MovieRequest(
        @NotBlank @Size(max = 100) String title,
        @NotBlank @Size(max = 100) String director,
        @NotBlank @Size(max = 50) String genre,
        @NotNull @DecimalMin("0.0") @DecimalMax("10.0") Double rating,
        @NotNull @Positive Integer releaseYear,
        @NotNull @Positive Integer runningTime
) {
}