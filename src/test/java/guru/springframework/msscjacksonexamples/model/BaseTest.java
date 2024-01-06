package guru.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    BeerDto getDto(){
        return new BeerDto.Builder(UUID.randomUUID(), "beerName","IPA", 123545L)
                .price(BigDecimal.valueOf(6.5))
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .build();
    }
}
