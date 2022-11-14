package com.musicstorecatalog.musicStoreCatalog.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicstorecatalog.musicStoreCatalog.model.Artist;
import com.musicstorecatalog.musicStoreCatalog.repository.ArtistRepository;
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
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {
    
    @MockBean
    private ArtistRepository artistRepository;
    
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private Artist inputArtist1;
    private Artist inputArtist2;
    private Artist inputArtist3;

    private String inputArtist1Json;
    private String inputArtist2Json;
    private String inputArtist3Json;

    private Artist outputArtist1;
    private Artist outputArtist2;
    private Artist outputArtist3;

    private String outputArtist1Json;
    private String outputArtist2Json;

    private List<Artist> inputArtistList = new ArrayList<>();

    private List<Artist> outputArtistList = new ArrayList<>();
    private String outputArtistListJson;

    @Before
    public void setUp()throws Exception {
        inputArtist1= new Artist("Michel Jackson", "@Mjackson", "@mjackson");
        inputArtist2 = new Artist("Aster Awok", "@Aster", "@AsterAwok");
        inputArtist3 = new Artist("Tylor Swift", "@taylorswift", "@taylorswift13");
        
        inputArtistList.add(inputArtist1);
        inputArtistList.add(inputArtist2);
        
        inputArtist1Json = mapper.writeValueAsString(inputArtist1);
        inputArtist2Json = mapper.writeValueAsString(inputArtist2);
        inputArtist3Json = mapper.writeValueAsString(inputArtist3);

        outputArtist1 = new Artist(1,"Michel Jackson", "@Mjackson", "@mjackson");
        outputArtist2 = new Artist(2, "Aster Awok", "@Aster", "@AsterAwok");
        outputArtist3 = new Artist(3, "Tylor Swift", "@taylorswift", "@taylorswift13");

        outputArtistList.add(outputArtist1);
        outputArtistList.add(outputArtist2);
        
        outputArtist1Json = mapper.writeValueAsString(outputArtist1);
        outputArtist2Json = mapper.writeValueAsString(outputArtist2);
        
        outputArtistListJson = mapper.writeValueAsString(outputArtistList);
 
        
    }

    @Test
    public void shouldReturn201AndArtistOnPost()throws Exception {

        doReturn(outputArtist1).when(artistRepository).save(inputArtist1);

        mockMvc.perform(
                        post("/artist")
                                .content(inputArtist1Json)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputArtist1Json));
    }

    @Test
    public void shouldUpdateArtist()throws Exception {

        inputArtist1.setInstagram("@michaeljackson");

        String inputJson = mapper.writeValueAsString(inputArtist1);

        mockMvc.perform(put("/artist")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetArtistById()throws Exception {

        doReturn(Optional.of(outputArtist2)).when(artistRepository).findById(2);

        mockMvc.perform(get("/artist/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputArtist2Json));

    }

    @Test
    public void shouldDeleteArtist()throws Exception {

        mockMvc.perform(delete("/artist/2"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetAllTheArtists() throws Exception{

        doReturn(outputArtistList).when(artistRepository).findAll();

        mockMvc.perform(get("/artist"))
                .andExpect(content().json(outputArtistListJson))
                .andExpect(status().isOk());
    }


    @Test
    public void shouldReturnArtistByName()throws Exception {

        List<Artist> artistList = new ArrayList<>();

        artistList.add(outputArtist3);

        String outputJson = mapper.writeValueAsString(artistList);

        doReturn(artistList).when(artistRepository).findByName("Tylor Swift");

        mockMvc.perform(get("/artist/name/Tylor Swift"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
    
}