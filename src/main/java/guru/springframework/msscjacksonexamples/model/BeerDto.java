package guru.springframework.msscjacksonexamples.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public record BeerDto(@NotNull
                      @JsonProperty("beerId")
                      UUID id,
                      @NotBlank
                      String beerName,
                      @NotBlank
                      String beerStyle,
                      @Positive
                      Long upc,

                      @JsonFormat(shape = JsonFormat.Shape.STRING)
                      BigDecimal price,
                      OffsetDateTime createdDate,
                      @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
                      OffsetDateTime lastUpdatedDate,
                      @JsonSerialize(using = LocalDateSerializer.class)
                      @JsonDeserialize(using = LocalDateDeserializer.class)
                      LocalDate myLocalDate
) {
    public static final class Builder {
        @NotNull
        @JsonProperty("beerId")
        private UUID id;
        @NotBlank
        private String beerName;
        @NotBlank
        private String beerStyle;
        @Positive
        private Long upc;

        @JsonFormat(shape = JsonFormat.Shape.STRING)
        private BigDecimal price;
        private OffsetDateTime createdDate;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
        private OffsetDateTime lastUpdatedDate;

        @JsonSerialize(using = LocalDateSerializer.class)
        @JsonDeserialize(using = LocalDateDeserializer.class)
        private LocalDate myLocalDate;

        public Builder(UUID id, String beerName, String beerStyle, Long upc) {
            this.id = id;
            this.beerName = beerName;
            this.beerStyle = beerStyle;
            this.upc = upc;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder createdDate(OffsetDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastUpdatedDate(OffsetDateTime lastUpdatedDate) {
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        public Builder myLocalDate(LocalDate myLocalDate) {
            this.myLocalDate = myLocalDate;
            return this;
        }

        public BeerDto build() {
            return new BeerDto(id, beerName, beerStyle, upc, price, createdDate, lastUpdatedDate, myLocalDate);
        }
    }
}
