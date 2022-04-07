package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper mapper;


    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto dto = getDto();
        String jsonString = mapper.writeValueAsString(dto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1212312313212,\"price\":\"12.99\",\"createdDate\":\"2022-04-05T01:17:51+0200\",\"lastUpdatedDate\":\"2022-04-05T01:17:51.593863+02:00\",\"myLocalDate\":\"20220405\",\"beerId\":\"b77de017-2cf8-4bf8-906d-9fd30d7e8eae\"}";
        BeerDto beer = mapper.readValue(json, BeerDto.class);
        System.out.println(beer);
    }

}