package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest{
    @Test
    void testKebab() throws JsonProcessingException {
        var dto = getDto();

        var json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }
}
