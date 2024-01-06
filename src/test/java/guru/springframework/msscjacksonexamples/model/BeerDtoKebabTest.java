package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest{
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        var dto = getDto();

        var json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        var json = "{\"id\":\"5fd6506a-d48b-465d-b0c8-c3b91bfb24aa\",\"beer-name\":\"beerName\",\"beer-style\":\"IPA\",\"upc\":123545,\"price\":6.5,\"created-date\":\"2024-01-06T19:47:41.3585177+01:00\",\"last-updated-date\":\"2024-01-06T19:47:41.3585177+01:00\"}";

        var dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}
