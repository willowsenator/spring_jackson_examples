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
        var json = "{\"id\":\"495beec9-7ad5-44e6-bb7f-187825ebb589\",\"beerName\":\"beerName\",\"beerStyle\":\"IPA\",\"upc\":123545,\"price\":6.5,\"createdDate\":\"2024-01-06T03:42:38.0057179+01:00\",\"lastUpdatedDate\":\"2024-01-06T03:42:38.0057179+01:00\"}";

        var dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}