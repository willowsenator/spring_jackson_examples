package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        var beerDto = getDto();

        var jsonString = mapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        var json = "{\"id\":\"495beec9-7ad5-44e6-bb7f-187825ebb589\",\"beerName\":\"beerName\",\"beerStyle\":\"IPA\",\"upc\":123545,\"price\":6.5,\"createdDate\":\"2024-01-06T03:42:38.0057179+01:00\",\"lastUpdatedDate\":\"2024-01-06T03:42:38.0057179+01:00\"}";

        var dto = mapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}