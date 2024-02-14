package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Test
    void testSerializeDto() throws JsonProcessingException {
        var beerDto = getDto();

        var jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        var json = "{\"beerId\":\"ff3c92bd-386e-4e51-9870-0929ddd5617d\",\"beerName\":\"beerName\",\"beerStyle\":\"IPA\",\"upc\":123545,\"price\":\"6.5\",\"createdDate\":\"2024-01-06T20:42:09.4635701+01:00\",\"lastUpdatedDate\":\"2024-01-06T20:42:09+0100\",\"myLocalDate\":\"20240106\"}";

        var dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}