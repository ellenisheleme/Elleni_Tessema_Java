package com.musicstorecatalog.musicStoreCatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicstorecatalog.musicStoreCatalog.model.Album;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.repository.AlbumRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @MockBean
    private AlbumRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private Album inputAlbum1;
    private Album inputAlbum2;
    private Album inputAlbum3;

    private String inputAlbum1Json;
    private String inputAlbum2Json;

    private Album outputAlbum1;
    private Album outputAlbum2;
    private Album outputAlbum3;

    private String outputAlbum1Json;
    private String outputAlbum2Json;

    private List<Album> inputAlbumList = new ArrayList<>();

    private List<Album> outputAlbumList = new ArrayList<>();
    private String outputAlbumListJson;

    @Before
    public void setUp()throws Exception {

        inputAlbum1 = new Album("Billie Jean", 1, LocalDate.ofEpochDay(1982-05-27),1,new BigDecimal("10.99"));
        inputAlbum2 = new Album("Beat It", 2, LocalDate.ofEpochDay(1982-12-27),1,new BigDecimal("12.99"));
        inputAlbum3 = new Album("Thriller", 3, LocalDate.ofEpochDay(1982-12-27),1,new BigDecimal("15.99"));


        inputAlbumList.add(inputAlbum1);
        inputAlbumList.add(inputAlbum2);
        inputAlbumList.add(inputAlbum3);

        inputAlbum1Json = mapper.writeValueAsString(inputAlbum1);
        inputAlbum2Json = mapper.writeValueAsString(inputAlbum2);

        outputAlbum1 = new Album(1, "Billie Jean", 1, LocalDate.ofEpochDay(1982-05-27),1,new BigDecimal("10.99"));
        outputAlbum2 = new Album(2, "Beat It", 2, LocalDate.ofEpochDay(1982-12-27),1,new BigDecimal("12.99"));
        outputAlbum3 = new Album(3, "Thriller", 3, LocalDate.ofEpochDay(1982-12-27),1,new BigDecimal("15.99"));

        outputAlbumList.add(outputAlbum1);
        outputAlbumList.add(outputAlbum2);


        outputAlbum1Json = mapper.writeValueAsString(outputAlbum1);
        outputAlbum2Json = mapper.writeValueAsString(outputAlbum2);

        outputAlbumListJson = mapper.writeValueAsString(outputAlbumList);

    }
    @Test
    public void shouldReturn201AndAlbumOnPost()throws Exception {

        doReturn(outputAlbum1).when(repository).save(inputAlbum1);

        mockMvc.perform(
                post("/album")
                        .content(inputAlbum1Json)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputAlbum1Json));
    }



    @Test
    public void shouldUpdateAlbum()throws Exception {

        inputAlbum1.setPrice(new BigDecimal("11.99"));
        inputAlbum1.setrelease_date(LocalDate.ofEpochDay(1982-05-28));

        String inputJson = mapper.writeValueAsString(inputAlbum1);

        mockMvc.perform(put("/album")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetAlbumById()throws Exception {

       doReturn(Optional.of(outputAlbum2)).when(repository).findById(2);

       mockMvc.perform(get("/album/2"))
               .andExpect(status().isOk())
               .andExpect(content().json(outputAlbum2Json));

    }

    @Test
    public void shouldDeleteAlbum()throws Exception {

        mockMvc.perform(delete("/album/3"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetAllTheAlbums() throws Exception{

        doReturn(outputAlbumList).when(repository).findAll();

        mockMvc.perform(get("/album"))
                .andExpect(content().json(outputAlbumListJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAlbumByTitle()throws Exception {

       List<Album> albumList = new ArrayList<>();

       albumList.add(outputAlbum3);

       String outputJson = mapper.writeValueAsString(albumList);

       doReturn(albumList).when(repository).findByTitle("Thriller");

       mockMvc.perform(get("/album/title/Thriller"))
               .andExpect(status().isOk());

    }

}