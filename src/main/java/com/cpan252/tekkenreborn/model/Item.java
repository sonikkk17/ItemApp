package com.cpan252.tekkenreborn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    private Brand brandFrom;
    @NonNull
    @Min(2021)
    private int yearOfCreation;
    @NotNull
    @DecimalMin(value = "1000.0", inclusive = true)
    private BigDecimal price;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

    public enum Brand {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR   ("Dior");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }


}
