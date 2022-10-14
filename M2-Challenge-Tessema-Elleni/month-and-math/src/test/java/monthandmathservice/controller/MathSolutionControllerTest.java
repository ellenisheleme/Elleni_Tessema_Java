package monthandmathservice.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import monthandmathservice.model.MathSolution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper  mapper= new ObjectMapper();

    @Test
    public void shouldReturnAnswerSumOfOperand1AndOperand2() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("5");
        inputSolution.setOperand2("4");
        inputSolution.setOperation("add");
        inputSolution.setAnswer(Integer.parseInt(inputSolution.getOperand1()) + Integer.parseInt(inputSolution.getOperand2()));

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT

        mockMvc.perform(
               post("/add")
                       .content(inputJson)
                       .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void shouldReturn422WhenOperandIsNotANumber() throws Exception{
        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("TryIt");
        inputSolution.setOperand2("4");
        inputSolution.setOperation("add");

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422WhenOperandIsMissed() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand2("4");
        inputSolution.setOperation("add");

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT

        mockMvc.perform(
                        post("/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturnAnswerDifferenceOfOperand1AndOperand2() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("5");
        inputSolution.setOperand2("4");
        inputSolution.setOperation("subtract");
        inputSolution.setAnswer(Integer.parseInt(inputSolution.getOperand1()) - Integer.parseInt(inputSolution.getOperand2()));

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT
        mockMvc.perform(
                        post("/subtract")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void shouldReturnAnswerQuotientOfOperand1AndOperand2() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("4");
        inputSolution.setOperand2("2");
        inputSolution.setOperation("divide");
        inputSolution.setAnswer(Integer.parseInt(inputSolution.getOperand1()) / Integer.parseInt(inputSolution.getOperand2()));

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturn422WhenOperand2Is0() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("4");
        inputSolution.setOperand2("0");
        inputSolution.setOperation("divide");

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT
        mockMvc.perform(
                        post("/divide")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test

    public void shouldReturnAnswerProductOfOperand1AndOperand2() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("4");
        inputSolution.setOperand2("2");
        inputSolution.setOperation("multiply");
        inputSolution.setAnswer(Integer.parseInt(inputSolution.getOperand1()) * Integer.parseInt(inputSolution.getOperand2()));

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT
        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturn422WhenOperandIsNotANumberMultiplyingNumbers() throws Exception{
        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand1("TryIt");
        inputSolution.setOperand2("4");
        inputSolution.setOperation("/multiply");

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422WhenOperandIsMissedWhenMultiplying() throws Exception{

        //ARRANGE
        MathSolution inputSolution = new MathSolution();
        inputSolution.setOperand2("4");
        inputSolution.setOperation("/multiply");

        String inputJson= mapper.writeValueAsString(inputSolution);

        //ACT

        mockMvc.perform(
                        post("/multiply")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

}