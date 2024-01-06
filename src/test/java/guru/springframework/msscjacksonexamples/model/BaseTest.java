package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    @Autowired
    ObjectMapper objectMapper;
    BeerDto getDto(){
        return new BeerDto.Builder(UUID.randomUUID(), "beerName","IPA", 123545L)
                .price(BigDecimal.valueOf(6.5))
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .build();
    }
}
