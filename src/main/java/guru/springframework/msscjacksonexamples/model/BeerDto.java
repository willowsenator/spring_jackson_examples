package guru.springframework.msscjacksonexamples.model;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
/**
 * Created by jt on 2019-04-20.
 */
public record BeerDto( @NotNull UUID id,
                       @NotBlank String beerName,
                       @NotBlank String beerStyle,
                       @Positive Long upc,
                      BigDecimal price,
                      OffsetDateTime createdDate,
                      OffsetDateTime lastUpdatedDate
                      ) {
    public static final class Builder{
        @NotNull
        private UUID id;
        @NotBlank
        private String beerName;
        @NotBlank
        private String beerStyle;
        @Positive
        private Long upc;
        private BigDecimal price;
        private OffsetDateTime createdDate;
        private OffsetDateTime lastUpdatedDate;

        public Builder(UUID id, String beerName, String beerStyle, Long upc){
            this.id = id;
            this.beerName = beerName;
            this.beerStyle = beerStyle;
            this.upc = upc;
        }

        public Builder price(BigDecimal price){
            this.price = price;
            return this;
        }

        public Builder createdDate(OffsetDateTime createdDate){
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastUpdatedDate(OffsetDateTime lastUpdatedDate){
            this.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        public BeerDto build(){
            return new BeerDto(id, beerName, beerStyle, upc, price, createdDate, lastUpdatedDate);
        }
    }
}
