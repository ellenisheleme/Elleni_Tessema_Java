package monthandmathservice.controller;
import monthandmathservice.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {
    @Autowired
   private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnAllMonthsInTheList() throws Exception {
        mockMvc.perform(get("/month"))
                .andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    public void shouldReturnTheAssociatedMonthName() throws Exception{

        Month month = new Month(3, "March");

        String outPutJson  = mapper.writeValueAsString(month);

        mockMvc.perform(get("/month/3"))
                .andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().json(outPutJson));
    }
    @Test
    public void shouldReturn422WhenAttemptingToGetMonthNameWithNumberBelow1orAbove12()throws Exception{
        Month month  = new Month(13, "Is this Month");

        String outPutJson  = mapper.writeValueAsString(month);
        mockMvc.perform(get("/month/13"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

}