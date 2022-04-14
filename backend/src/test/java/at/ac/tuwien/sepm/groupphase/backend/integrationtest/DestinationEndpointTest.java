package at.ac.tuwien.sepm.groupphase.backend.integrationtest;

import at.ac.tuwien.sepm.groupphase.backend.basetest.TestData;
import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.SimpleDestinationDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.Destination;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class DestinationEndpointTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Creating a specific destination and trying to get it.
     */
    @Test
    public void createAndGetDestinationTest() throws Exception {

        SimpleDestinationDto simpleDestinationDto = new SimpleDestinationDto();

        simpleDestinationDto.setName("name");
        ObjectMapper objectMapper = new ObjectMapper();


        ResultActions perform = mvc
            .perform(post(TestData.DESTINATION_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(simpleDestinationDto)));

        MvcResult result = perform
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().contentType("application/json"))
            .andReturn();

        SimpleDestinationDto simpleDestinationResponse = objectMapper.readValue(result.getResponse().getContentAsString(),
            SimpleDestinationDto.class);

        mvc.perform(get("/api/v1/destinations/" + simpleDestinationResponse.getId()).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("id", is(simpleDestinationResponse.getId().intValue())))
            .andExpect(jsonPath("name", is(simpleDestinationResponse.getName())));

    }

    /**
     * Trying to add specific destination and then expecting a bad request while the name of the destination is missing
     * and it is required field.
     */

    @Test
    public void createDestinationForBadRequestTest() throws Exception {
        Destination destination = new Destination();

        // destination.setName("name");

        ObjectMapper objectMapper = new ObjectMapper();

        ResultActions perform = mvc
            .perform(post(TestData.DESTINATION_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(destination)));

        perform.andDo(print()).andExpect(status().isBadRequest());
    }


}
