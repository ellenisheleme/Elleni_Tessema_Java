package com.musicstorecatalog.musicStoreCatalog.controller;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.repository.LabelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(LabelController.class)
public class LabelControllerTest {
    @MockBean
    private LabelRepository labelRepository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Label inputLabel1;
    private Label inputLabel2;
    private Label inputLabel3;

    private String inputLabel1Json;
    private String inputLabel2Json;
    private String inputLabel3Json;

    private Label outputLabel1;
    private Label outputLabel2;
    private Label outputLabel3;

    private String outputLabel1Json;
    private String outputLabel2Json;

    private List<Label> inputLabelList = new ArrayList<>();

    private List<Label> outputLabelList = new ArrayList<>();
    private String outputLabelListJson;

    @Before
    public void setUp()throws Exception {
        inputLabel1= new Label("Butterflies", "www.michaljackson.com");
        inputLabel2 = new Label("Midnights", "tylorswift.com");
        inputLabel3 = new Label("The Weeknd", "www.theweeknd.com" );

        inputLabelList.add(inputLabel1);
        inputLabelList.add(inputLabel2);

        inputLabel1Json = mapper.writeValueAsString(inputLabel1);
        inputLabel2Json = mapper.writeValueAsString(inputLabel2);
        inputLabel3Json = mapper.writeValueAsString(inputLabel3);

        outputLabel1 = new Label(1,"Butterflies", "www.michaljackson.com");
        outputLabel2 = new Label(2, "Midnights", "tylorswift.com");
        outputLabel3 = new Label(3, "The Weeknd", "www.theweeknd.com" );

        outputLabelList.add(outputLabel1);
        outputLabelList.add(outputLabel2);

        outputLabel1Json = mapper.writeValueAsString(outputLabel1);
        outputLabel2Json = mapper.writeValueAsString(outputLabel2);

        outputLabelListJson = mapper.writeValueAsString(outputLabelList);

    }
    @Test
    public void shouldReturn201AndLabelOnPost()throws Exception {

        doReturn(outputLabel1).when(labelRepository).save(inputLabel1);

        mockMvc.perform(
                        post("/label")
                                .content(inputLabel1Json)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputLabel1Json));
    }

    @Test
    public void shouldUpdateLabel()throws Exception {

        inputLabel1.setName("Fearless");

        String inputJson = mapper.writeValueAsString(inputLabel1);

        mockMvc.perform(put("/label")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }
    @Test
    public void shouldGetLabelById()throws Exception {

        doReturn(Optional.of(outputLabel2)).when(labelRepository).findById(2);

        mockMvc.perform(get("/label/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputLabel2Json));
    }
    
    
    @Test
    public void shouldGetAllTheLabels() throws Exception{

        doReturn(outputLabelList).when(labelRepository).findAll();

        mockMvc.perform(get("/label"))
                .andExpect(content().json(outputLabelListJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnLabelByName()throws Exception {

        List<Label> labelList = new ArrayList<>();

        labelList.add(outputLabel3);

        String outputJson = mapper.writeValueAsString(labelList);

        doReturn(labelList).when(labelRepository).findByName("The Weeknd");

        mockMvc.perform(get("/label/name/The Weeknd"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

}